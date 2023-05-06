package com.example.connectmessenger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfigurationSource;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig2 {
    @Value("${custom.secret}")
    private String secret;
    @Value("${custom.jwt-expiration-time}")
    private Long expirationTime;
    private final CorsConfigurationSource corsConfigurationSource;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable().authorizeHttpRequests()
                .requestMatchers("/login", "/websocket/**", "/swagger-ui.html", "/v2/api-docs",
                        "/swagger-resources/**", "/images/**", "/test-s3")
                .permitAll()
                .anyRequest().authenticated()

                .and()
                .cors().configurationSource(corsConfigurationSource)

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .addFilter(new JsonObjectAuthenticationFilter(secret, expirationTime, authenticationManager))
                .addFilterAfter(new JwtAuthorizationFilter(secret, userDetailsService), JsonObjectAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

                .and().headers().frameOptions().disable();
        return http.build();
    }
}
