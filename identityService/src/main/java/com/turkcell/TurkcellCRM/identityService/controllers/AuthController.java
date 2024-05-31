package com.turkcell.TurkcellCRM.identityService.controllers;

import com.turkcell.TurkcellCRM.identityService.services.abstracts.AuthService;
import com.turkcell.TurkcellCRM.identityService.services.dtos.LoginRequest;
import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest request)
    {
        authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
    @PostMapping("/tokenControl")
    @ResponseStatus(HttpStatus.OK)
    public boolean tokenControl(@RequestBody String token)
    {
        return authService.tokenControl(token);
    }
}
