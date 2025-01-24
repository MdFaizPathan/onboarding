package com.example.onboarding.service;

import com.example.onboarding.model.UserEntity;
import com.example.onboarding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserEntity signUp(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public UserEntity signIn(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }
        return user.get();
    }

    public String forgotPassword(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("Email not found.");
        }
        String resetToken = UUID.randomUUID().toString();
        UserEntity existingUser = user.get();
        existingUser.setResetToken(resetToken);
        userRepository.save(existingUser);
        return resetToken;
    }
}
