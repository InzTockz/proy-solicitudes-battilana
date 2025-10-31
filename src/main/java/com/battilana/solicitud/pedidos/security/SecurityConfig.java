package com.battilana.solicitud.pedidos.security;

import com.battilana.solicitud.pedidos.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
                .cors(cors -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("*"));
                    configuration.setAllowedHeaders(List.of("*"));
                    configuration.setAllowedMethods(List.of("*"));
                })
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                authorize -> {
                    authorize
                            //.requestMatchers("/api/v1/usuario/list").hasAnyRole("USUARIO")
                            .requestMatchers("/api/v1/usuario/list").permitAll()
                            .requestMatchers("/api/v1/usuario/register").hasAnyRole("ADMINISTRADOR")
                            .requestMatchers("/api/v1/usuario/login").permitAll()
                            .requestMatchers("/api/v1/sap/**").permitAll()
                            .anyRequest().authenticated();
                }
        ).addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
