package com.example.project3.controller;

import com.example.project3.model.User;
import com.example.project3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")  // Akses untuk USER atau ADMIN
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok("User profile accessed");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")  // Hanya ADMIN
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/manage")
    @PreAuthorize("hasRole('ADMIN')")  // Hanya ADMIN
    public ResponseEntity<String> manageUsers() {
        return ResponseEntity.ok("Managing users (ADMIN only)");
    }
}