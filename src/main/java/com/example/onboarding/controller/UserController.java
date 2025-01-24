package com.example.onboarding.controller;

import com.example.onboarding.model.UserEntity;
import com.example.onboarding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signUp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        UserEntity user = userService.signUp(email, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserEntity> signIn(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        UserEntity user = userService.signIn(email, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String resetToken = userService.forgotPassword(email);
        return ResponseEntity.ok(resetToken);
    }
}
