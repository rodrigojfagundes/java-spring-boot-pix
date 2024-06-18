package io.github.rodrigojfagundes.paymentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.rodrigojfagundes.paymentsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	UserDetails findByEmail(String email);
	
	
}
