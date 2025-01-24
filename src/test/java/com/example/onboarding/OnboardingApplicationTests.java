package com.example.onboarding;

import com.example.onboarding.model.UserEntity;
import com.example.onboarding.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OnboardingApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Test
	void testSignUp() {
		String email = "test@example.com";
		String password = "password123";

		UserEntity user = userService.signUp(email, password);

		assertNotNull(user);
		assertEquals(email, user.getEmail());
		assertTrue(passwordEncoder.matches(password, user.getPassword()));
	}

	@Test
	void testSignIn() {
		String email = "testsignin@example.com";
		String password = "password123";

		userService.signUp(email, password);
		UserEntity user = userService.signIn(email, password);

		assertNotNull(user);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testForgotPassword() {
		String email = "testforgot@example.com";
		String password = "password123";

		userService.signUp(email, password);
		String resetToken = userService.forgotPassword(email);

		assertNotNull(resetToken);
	}
}
