package com.battilana.solicitud.pedidos.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    private static String sessionCookie;

    public static void setSession(String cookie){
        sessionCookie = cookie;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        //return (RequestTemplate template) -> {
        return template -> {
            if(sessionCookie!=null){
                template.header("Cookie", sessionCookie);
            }
        };
    }
}
