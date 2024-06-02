package com.turkcell.TurkcellCRM.identityService.services.concretes;

import com.turkcell.TurkcellCRM.identityService.dataAccess.UserRepository;
import com.turkcell.TurkcellCRM.identityService.entities.User;
import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Mock
    private  UserRepository userRepository;
    @Mock
    private  PasswordEncoder passwordEncoder;
    @Mock
    private  UserDetails userDetails;

    private UserManager userManager;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userManager= new UserManager(userRepository,passwordEncoder);
    }

    @Test
    void loadUserByUsername() throws AccessDeniedException {
        String username="spring@email.com";
        RegisterRequest request = new RegisterRequest("pass","email@email.com","adi","soyadi");
        when(passwordEncoder.encode(request.getPassword())).thenReturn("pass");
        User user =new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        when(userRepository.findByEmail(username)).thenReturn(Optional.of(user));
        userManager.loadUserByUsername(username);
        assert true;

    }
    @Test
    void loadUserByUsernameThrowsAccessDeniedException() throws AccessDeniedException {
        String username="spring@email.com";
        RegisterRequest request = new RegisterRequest("pass","email@email.com","adi","soyadi");
        when(passwordEncoder.encode(request.getPassword())).thenReturn("pass");
        User user =new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        when(userRepository.findByEmail(username)).thenReturn(Optional.empty());

        assertThrows(AccessDeniedException.class, () -> {
            userManager.loadUserByUsername(username);
        });

    }

    @Test
    void add(){
        RegisterRequest request = new RegisterRequest("pass","email@email.com","adi","soyadi");
        when(passwordEncoder.encode(request.getPassword())).thenReturn("pass");
        User user =new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userManager.add(request);


    }
}
