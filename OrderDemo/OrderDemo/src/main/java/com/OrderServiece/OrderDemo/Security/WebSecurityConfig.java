package com.OrderServiece.OrderDemo.Security;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.server.SecurityWebFilterChain;

// import feign.Logger;

// @Configuration
// @EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class WebSecurityConfig {
// // Logger.ErrorLogger("")
//     // @Bean
//     // public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
//     //     http
//     //             .csrf().disable()
//     //             .authorizeRequests(
//     //                     authorizeRequest -> authorizeRequest
//     //                     .anyRequest()
//     //                             .authenticated())
//     //             .oauth2ResourceServer(
//     //                     OAuth2ResourceServerConfigurer::jwt);

//     //     return http.build();
//     // }
//     @Bean
//     public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
//         System.out.println("haii");
//         http
//             .csrf().disable() // 🔴 This must come before anything else
//             .authorizeRequests(auth -> auth
//                 .anyRequest().authenticated()
//             )
//             .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

//         return http.build();
//     }

// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Security FilterChain Configuring...");

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());

        return http.build();
    }
}




