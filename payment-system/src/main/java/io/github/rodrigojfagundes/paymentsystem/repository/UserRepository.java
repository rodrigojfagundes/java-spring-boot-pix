package io.github.rodrigojfagundes.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.rodrigojfagundes.paymentsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);
    User findByVerificationCode(String verificationCode);
}
