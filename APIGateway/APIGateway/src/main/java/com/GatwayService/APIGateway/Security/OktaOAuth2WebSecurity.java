package com.GatwayService.APIGateway.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OktaOAuth2WebSecurity {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .authorizeHttpRequests(authorizeRequests -> authorizeRequests
    // .requestMatchers("/public/**").permitAll() // Allow unauthenticated access to
    // public endpoints
    // .anyRequest().authenticated() // Secure all other endpoints
    // )
    // .oauth2Login(oauth2Login -> oauth2Login
    // .loginPage("/login") // Optional: customize your login page if needed
    // )
    // .oauth2ResourceServer(oauth2 -> oauth2
    // .jwt()); // Use JWT for OAuth2 Resource Server

    // return http.build();
    // }
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

}
