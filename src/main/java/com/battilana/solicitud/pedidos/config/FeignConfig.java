package com.battilana.solicitud.pedidos.config;

import feign.RequestInterceptor;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;

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

//    @Bean
//    public feign.Client feignClient() throws Exception{
//
//        TrustStrategy trustAll = (chain, authType) -> true;
//
//        SSLContext sslContext = SSLContexts.custom()
//                .loadTrustMaterial(null, trustAll)
//                .build();
//
//        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
//                sslContext, NoopHostnameVerifier.INSTANCE
//        );
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(socketFactory)
//                .build();
//
//        return new feign.httpclient.ApacheHttpClient(httpClient);
//    }
}
