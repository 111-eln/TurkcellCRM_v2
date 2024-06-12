package com.turkcell.TurkcellCRM.basketService.configurations;

import com.turkcell.TurkcellCRM.CoreService.configuration.BaseSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final BaseSecurityService baseSecurityService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        baseSecurityService.configureCoreSecurity(http);
        http.authorizeHttpRequests(
                req -> req
                        .requestMatchers("/api/v1/basket")
                        .permitAll()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
}

