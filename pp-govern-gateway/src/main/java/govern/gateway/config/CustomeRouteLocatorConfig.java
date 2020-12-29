package govern.gateway.config;

import govern.gateway.filters.Authfilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomeRouteLocatorConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p
                        .path("/source/**")
                        .filters(f -> f.filter(new Authfilter()).stripPrefix(1))
                        .uri("lb://pp-service-source"))
                .build();
    }
}
