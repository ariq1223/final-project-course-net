package com.example.project2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.entity.User;
import com.example.project2.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User logged = service.login(user.getEmail(), user.getPassword());
        return "Login successful for " + logged.getName() + ". Verified: " + logged.isVerified();
    }

    @PostMapping("/verify")
    public User verify(@RequestBody User user) {
        return service.verify(user.getEmail());
    }
}
