package com.tech.lunch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración de seguridad con Spring Security 6.x
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/usuarios/**").permitAll()  // Permite el acceso sin autenticación
                        .requestMatchers("/api/categorias/**").permitAll()
                        .requestMatchers("/api/items/**").permitAll()
                        .requestMatchers("/api/cartas/**").permitAll()
                        .requestMatchers("/api/carta-items/**").permitAll()
                        .requestMatchers("/api/reservas/**").permitAll()
                        .requestMatchers("/api/reserva-items/**").permitAll()
                        .requestMatchers("/api/pedidos/**").permitAll()
                        .requestMatchers("/api/pedido-items/**").permitAll()
                        .requestMatchers("/api/transacciones/**").permitAll()
                        .requestMatchers("/api/retroalimentaciones/**").permitAll()
                        .requestMatchers("/api/carritos/**").permitAll()
                        .requestMatchers("/api/carrito-items/**").permitAll()
                        .requestMatchers("/api/images/**").permitAll()
                        .anyRequest().authenticated()  // Requiere autenticación para el resto de las solicitudes
                )
                .csrf(csrf -> csrf.disable());  // Desactiva CSRF para las API REST

        return http.build();  // Se construye la configuración de seguridad
    }
}