package io.github.rodrigojfagundes.paymentsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.rodrigojfagundes.paymentsystem.entities.User;
import io.github.rodrigojfagundes.paymentsystem.repositories.UserRepository;
import io.github.rodrigojfagundes.paymentsystem.utils.RandomString;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerUser(User user) {
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new RuntimeException("This email already exists");
		}
		else {
			String encodedPassword = passwordEncoder.encode(
					user.getPassword());
			user.setPassword(encodedPassword);
			
			String randomCode = RandomString.generateRandomString(64);
			user.setVerificationCode(randomCode);
			user.setEnabled(false);
			User savedUser = userRepository.save(user);
			return savedUser;
		}
		
	}
	
}
