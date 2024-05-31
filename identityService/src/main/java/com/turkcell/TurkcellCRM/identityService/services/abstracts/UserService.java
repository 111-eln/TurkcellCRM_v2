package com.turkcell.TurkcellCRM.identityService.services.abstracts;

import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}