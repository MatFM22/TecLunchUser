package com.tech.lunch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración de seguridad con Spring Security 6.x
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/usuarios/**").permitAll()  // Permite el acceso sin autenticación
                        .anyRequest().authenticated()  // Requiere autenticación para el resto de las solicitudes
                )
                .csrf(csrf -> csrf.disable());  // Desactiva CSRF para las API REST

        return http.build();  // Se construye la configuración de seguridad
    }
}