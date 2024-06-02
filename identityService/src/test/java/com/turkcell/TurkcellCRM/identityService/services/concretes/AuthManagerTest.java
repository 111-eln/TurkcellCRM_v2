package com.turkcell.TurkcellCRM.identityService.services.concretes;

import com.turkcell.TurkcellCRM.CoreService.jwt.JwtService;
import com.turkcell.TurkcellCRM.identityService.services.abstracts.AuthService;
import com.turkcell.TurkcellCRM.identityService.services.abstracts.UserService;
import com.turkcell.TurkcellCRM.identityService.services.dtos.LoginRequest;
import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;
import com.turkcell.TurkcellCRM.identityService.services.rules.AuthServiceRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class AuthManagerTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserService userService;

    private AuthManager authManager;

    @Mock
    private  UserDetails userDetails;
    @Mock
    private AuthServiceRules businessRules;

    @Mock
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authManager= new AuthManager(passwordEncoder,authenticationManager,jwtService,userService,businessRules);

    }

    @Test
    void testRegister() {
        RegisterRequest request = new RegisterRequest();
        authManager.register(request);
        assert true;
    }

    @Test
    void testLogin() {
        String email = "test@example.com";
        String password = "password";
        LoginRequest request = new LoginRequest(email, password);

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        doNothing().when(businessRules).isAuthenticated(authentication);


        when(userService.loadUserByUsername(request.getEmail())).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("email");
        when(jwtService.generateToken(email, List.of("ROLE_USER"))).thenReturn("Token");

        authManager.login(request);
        assert true;
    }
    @Test
    void testLoginThrowsNotAuthenticated() {
        String email = "test@example.com";
        String password = "password";
        LoginRequest request = new LoginRequest(email, password);

        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        doThrow(new RuntimeException()).when(businessRules).isAuthenticated(authentication);

        UserDetails userDetails = mock(UserDetails.class);
        when(userService.loadUserByUsername(request.getEmail())).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn(email);

        when(jwtService.generateToken(email, List.of("ROLE_USER"))).thenReturn("Token");

        assertThrows(RuntimeException.class, () -> {
            authManager.login(request);
        });
    }

    @Test
    void testTokenControl() {
        String token = "jwt-token";
        String username = "test@example.com";

        when(jwtService.extractUsername(token)).thenReturn(username);
        when(jwtService.validateToken(token, username)).thenReturn(true);

        boolean isValid = authManager.tokenControl(token);

        assertTrue(isValid);
    }
    @Test
    void testTokenControlIsNotValid() {
        String token = "jwt-token";
        String username = "test@example.com";

        when(jwtService.extractUsername(token)).thenReturn(username);
        when(jwtService.validateToken(token, username)).thenReturn(false);

        assertFalse(authManager.tokenControl(token));
    }



}
