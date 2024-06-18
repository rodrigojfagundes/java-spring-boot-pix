package io.github.rodrigojfagundes.paymentsystem.dto;

import io.github.rodrigojfagundes.paymentsystem.entities.User;

public record UserRequest(String name, String email, String password) {
	
	public User toModel() {
		return new User(name, email, password);
	}
	
}
