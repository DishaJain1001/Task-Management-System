package com.example.task_management_system.controller;

import com.example.task_management_system.DTOs.AuthRequest;
import com.example.task_management_system.DTOs.AuthResponse;
import com.example.task_management_system.model.Role;
import com.example.task_management_system.model.User;
import com.example.task_management_system.Repository.UserRepository;
import com.example.task_management_system.Security.JwtUtils;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest req) {
        if (userRepository.existsByUsername(req.username())) {
            return ResponseEntity.badRequest().body("Username already taken");
        }
        User u = new User();
        u.setUsername(req.username());
        u.setPassword(passwordEncoder.encode(req.password()));
        u.setRoles(Set.of(Role.ROLE_USER)); // default role
        userRepository.save(u);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password()));
        var userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream().map(a -> a.getAuthority())
                .collect(Collectors.toSet());
        String token = jwtUtils.generateToken(userDetails.getUsername(), roles);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
