package com.turkcell.TurkcellCRM.orderService.core;

//import com.turkcell.TurkcellCRM.CoreService.configuration.BaseSecurityService;
import com.turkcell.TurkcellCRM.orderService.clients.IsCustomerExistClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
//    private final BaseSecurityService baseSecurityService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        baseSecurityService.configureCoreSecurity(http);
//        http.authorizeHttpRequests(
//                req -> req
//                        .anyRequest().permitAll()
//        );
//        return http.build();
//    }
    @Bean
    public ResourceBundleMessageSource bundleMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));
        return acceptHeaderLocaleResolver;
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}




