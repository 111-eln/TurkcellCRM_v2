package com.turkcell.TurkcellCRM.catalogService.configurations;

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
                        .requestMatchers("/catalogservice/api/v1/products/productStockControl",
                                "/catalogservice/api/v1/products/productTitleControl",
                                "/catalogservice/api/v1/products/existProductById/{id}",
                                "/catalogservice/api/v1/products/{id}")
                        .permitAll()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
}
