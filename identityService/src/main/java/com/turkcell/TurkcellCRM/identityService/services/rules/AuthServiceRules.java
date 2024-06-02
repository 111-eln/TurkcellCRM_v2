package com.turkcell.TurkcellCRM.identityService.services.rules;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceRules {

    public void isAuthenticated(Authentication authentication){
        if(!authentication.isAuthenticated())
            throw new RuntimeException("E-posta veya şifre hatalı.");
    }
}
