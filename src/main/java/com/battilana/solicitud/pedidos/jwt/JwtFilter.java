package com.battilana.solicitud.pedidos.jwt;

import com.battilana.solicitud.pedidos.security.CustomDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.battilana.solicitud.pedidos.jwt.JwtValidate.*;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final CustomDetailService customDetailService;

    public JwtFilter(CustomDetailService customDetailService) {
        this.customDetailService = customDetailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (tokenExiste(request, response)) {
                Claims claims = JwtValid(request);
                if (claims.get("authorities") != null) {
                    setAuthentication(claims, this.customDetailService);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }

            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
    }
}
