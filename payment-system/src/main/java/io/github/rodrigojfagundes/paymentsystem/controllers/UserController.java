package io.github.rodrigojfagundes.paymentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rodrigojfagundes.paymentsystem.dto.UserRequest;
import io.github.rodrigojfagundes.paymentsystem.entities.User;
import io.github.rodrigojfagundes.paymentsystem.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
		User user = userRequest.toModel();
		User userSaved = userService.registerUser(user);

		return ResponseEntity.ok().body(userSaved);
		
	}	
}
