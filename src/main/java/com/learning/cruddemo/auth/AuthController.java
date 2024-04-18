package com.learning.cruddemo.auth;

import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        AuthenticationResponse authResponse = authService.register(registerRequest);
        return  ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
       return ResponseEntity.ok(authService.authenticate(request));
    }

    // Existing endpoints...

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam("userId") Long userId,
                                                 @RequestParam("currentPassword") String currentPassword,
                                                 @RequestParam("newPassword") String newPassword) {
        authService.changePassword(userId, currentPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = authService.getAllUsers(); // Call the service method to fetch all users
        return ResponseEntity.ok(users); // Return the list of users in the response
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<Optional<UserAccount>> getUsersById(@PathVariable Long userId) {
        Optional<UserAccount> user = authService.getUsersById(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users/email/{email}")
    public ResponseEntity<UserAccount> getUserByEmail(@PathVariable String email) throws ResourceNotFoundException {
        UserAccount user = authService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }




}
