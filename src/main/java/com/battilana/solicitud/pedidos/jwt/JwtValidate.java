package com.battilana.solicitud.pedidos.jwt;

import com.battilana.solicitud.pedidos.security.CustomDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static com.battilana.solicitud.pedidos.jwt.Constants.*;

public class JwtValidate {

    public static boolean tokenExiste(HttpServletRequest request, HttpServletResponse response){
        String header = request.getHeader(HEADER_AUTHORIZATION);
        if(header == null || !header.startsWith(TOKEN_BEARER_PREFIX)){
            return false;
        } else {
            return true;
        }
    }

    public static Claims validacionJwt(HttpServletRequest request){
        String jwtToken = request.getHeader(HEADER_AUTHORIZATION).replace(TOKEN_BEARER_PREFIX, "");

        Claims claims = Jwts.parser()
                .verifyWith(claveSecreta(SUPER_SECRET_KEY))
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();

        return claims;
    }

    public static void colocarAutenticacion(Claims claims, CustomDetailService customDetailService){
        UserDetails userDetails = customDetailService.loadUserByUsername(claims.getSubject());

        System.out.println("Que esto: " + claims.getSubject());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(token);
    }
}
