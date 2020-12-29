package com.common.model.utils;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by admin on 2018/3/18.
 */
public class CookieUtil {

    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     */
    public static void addCookie(HttpServletResponse response,String domain,String path, String name,
                                 String value, int maxAge,boolean httpOnly) {
        ResponseCookie cookie=ResponseCookie.from(name, value)
        .domain(domain)
        .path(path)
        .maxAge(maxAge)
        .httpOnly(httpOnly)
        //.sameSite("None") //同源策略，none必须加secure为true
       // .secure(false)//若是https则true，http false
        .build();

        response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());
    }



    /**
     * 根据cookie名称读取cookie
     * @param request
     * @param cookieName1,cookieName2
     * @return map<cookieName,cookieValue>
     */

    public static Map<String,String> readCookie(HttpServletRequest request,String ... cookieNames) {
        Map<String,String> cookieMap = new HashMap<String,String>();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    String cookieValue = cookie.getValue();
                    for(int i=0;i<cookieNames.length;i++){
                        if(cookieNames[i].equals(cookieName)){
                            cookieMap.put(cookieName,cookieValue);
                        }
                    }
                }
            }
        return cookieMap;

    }


    //webflux读取cookie
    public static Map<String,String> readCookie(ServerHttpRequest request, String ... cookieNames) {
        Map<String,String> cookieMap = new HashMap<String,String>();
        MultiValueMap<String,HttpCookie> cookies=request.getCookies();
        for(String cookiename:cookieNames){
            if(cookies.containsKey(cookiename)){
                cookieMap.put(cookiename,cookies.get(cookiename).get(0).getValue());
            }
        }

        return cookieMap;

    }
}
