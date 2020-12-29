package govern.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.common.model.common.CommonCode;
import com.common.model.rdatatype.Rdatatype;
import govern.gateway.service.AuthService;
import org.apache.commons.lang.StringUtils;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.ApplicationContext;

import org.springframework.core.Ordered;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Component
public class Authfilter implements GatewayFilter, Ordered {


    AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //得到authservice
        //因为spring cloud gateway 实现自定义filter @autowired失效所以用此方法获得@service注入的对象
        ApplicationContext ctx=exchange.getApplicationContext();
        if(ctx!=null&&ctx.getBean("authService")!=null&&authService==null){
            authService=(AuthService)ctx.getBean("authService");
        }
       //得到request
        ServerHttpRequest request = exchange.getRequest();
        //得到response
        ServerHttpResponse response = exchange.getResponse();
        //取cookie中的身份令牌
        String tokenFromCookie = authService.getTokenFromCookie(request);
        if(StringUtils.isEmpty(tokenFromCookie)){
            //拒绝访问
            access_denied(exchange);
            return null;
        }
        //从header中取jwt
        String jwtFromHeader = authService.getJwtFromHeader(request);
        if(StringUtils.isEmpty(jwtFromHeader)){
            //拒绝访问
            access_denied(exchange);
            return null;
        }
        //从redis取出jwt的过期时间
        long expire = authService.getExpire(tokenFromCookie);
        if(expire<0){
            //拒绝访问
            access_denied(exchange);
            return null;
        }


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


    //拒绝访问
    private Mono<Void> access_denied(ServerWebExchange exchange)  {
        return Mono.defer(() -> {


            //构建响应的信息
            Rdatatype responseResult = Rdatatype.onSuccess(CommonCode.UNAUTHENTICATED);
            //转成json
            String jsonString = JSON.toJSONString(responseResult);
            ServerHttpResponse response = exchange.getResponse();

            response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString());
            DataBuffer buffer = response.bufferFactory().wrap(jsonString.getBytes());

            return response.writeWith(Flux.just(buffer));

        });
    }

}
