package com.turkcell.TurkcellCRM.identityService.services.abstracts;

import com.turkcell.TurkcellCRM.identityService.services.dtos.LoginRequest;
import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
    boolean tokenControl(String token);
}
