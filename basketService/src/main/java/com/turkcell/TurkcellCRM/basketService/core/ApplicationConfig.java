package com.turkcell.TurkcellCRM.basketService.core;

//import com.turkcell.TurkcellCRM.CoreService.configuration.BaseSecurityService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
@AllArgsConstructor
public class ApplicationConfig {


  /* @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       baseSecurityService.configureCoreSecurity(http);
       http.authorizeHttpRequests(
               req -> req
                       .requestMatchers(HttpMethod.GET,"/api/v1/basket/").permitAll()
                       .anyRequest().authenticated()
       );
       return http.build();
   }*/
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




