package com.tech.lunch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
                        .anyRequest().authenticated()  // Requiere autenticación para el resto de las solicitudes
                )
                .csrf(csrf -> csrf.disable());  // Desactiva CSRF para las API REST


        return http.build();  // Se construye la configuración de seguridad
    }

    // Configuración de CORS para permitir solicitudes desde otros orígenes
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes desde el frontend que esté en el puerto 3000
        registry.addMapping("/api/usuarios/**")
                .allowedOrigins("http://localhost:3000")  // Cambia esto por la URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
