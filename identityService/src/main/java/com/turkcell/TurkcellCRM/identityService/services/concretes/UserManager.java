package com.turkcell.TurkcellCRM.identityService.services.concretes;


import com.turkcell.TurkcellCRM.identityService.dataAccess.UserRepository;
import com.turkcell.TurkcellCRM.identityService.entities.User;
import com.turkcell.TurkcellCRM.identityService.services.abstracts.UserService;
import com.turkcell.TurkcellCRM.identityService.services.dtos.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new AccessDeniedException("Giriş başarısız."));
    }

    @Override
    public void add(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }
}
