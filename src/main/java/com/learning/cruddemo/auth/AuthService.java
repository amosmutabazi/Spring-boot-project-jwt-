package com.learning.cruddemo.auth;

import com.learning.cruddemo.configs.JwtService;
import com.learning.cruddemo.exceptions.InvalidPasswordException;
import com.learning.cruddemo.exceptions.LockedAccountException;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.UserAccount;
import com.learning.cruddemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;
    private  final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var userAccount = UserAccount.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
        var savedUser = userRepository.save(userAccount);
        String jwtToken = jwtService.generateToken(userAccount);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var userAccount = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if the account is locked
        if (userAccount.isLocked()) {
            throw new LockedAccountException("Account is locked. Please contact support.");
        }

        // Validate password
        if (!passwordEncoder.matches(request.getPassword(), userAccount.getPassword())) {
            // Increment failed login attempts
            userAccount.setFailedLoginAttempts(userAccount.getFailedLoginAttempts() + 1);
            // Check if the maximum attempts are reached
            if (userAccount.getFailedLoginAttempts() >= 3) {
                userAccount.setLocked(true); // Lock the account
            }
            userRepository.save(userAccount); // Update user account in the database
            throw new InvalidPasswordException("Invalid password");
        }

        // Reset failed login attempts upon successful login
        userAccount.setFailedLoginAttempts(0);
        userRepository.save(userAccount); // Update user account in the database

        // Authentication successful, generate JWT token
        String jwtToken = jwtService.generateToken(userAccount);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }

    @GetMapping("/public/email")
    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); // returns the email
    }

    public Optional<UserAccount> getUsersById(Long userId) throws UsernameNotFoundException {
        return userRepository.findById(Math.toIntExact(userId));
    }

    public void changePassword(Long userId, String currentPassword, String newPassword) {
        UserAccount userAccount = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Validate current password
        if (!passwordEncoder.matches(currentPassword, userAccount.getPassword())) {
            throw new InvalidPasswordException("Current password is incorrect");
        }

        // Encode and update new password
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        userAccount.setPassword(encodedNewPassword);
        userRepository.save(userAccount);
    }

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll(); // Fetch all users from the database
    }
    public UserAccount getUserByEmail(String email) throws ResourceNotFoundException {
        Optional<UserAccount> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }


}

