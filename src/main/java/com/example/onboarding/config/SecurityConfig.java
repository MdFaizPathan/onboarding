package com.example.onboarding.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                .requestMatchers("/api/users/signup", "/api/users/signin", "/api/users/forgot-password").permitAll() // Allow onboarding APIs
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().sameOrigin(); // Allow H2 console frames

        return http.build();

    }


}
