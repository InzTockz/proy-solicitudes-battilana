package com.battilana.solicitud.pedidos.jwt;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class Constants {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";
    public static final String SUPER_SECRET_KEY = "d3DGkSdnJ7DdZvluO6QUgkZhJ8IFPnEs89F0qCNODOG7d2BQ2FpR40PouFCqUN3KoblbbUuHvZ2";
    public static final long TOKEN_EXPIRATION_TIME = 3600000;

    public static SecretKey claveSecreta(String secretKey){
        byte[] keyBites = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBites);
    }
}
