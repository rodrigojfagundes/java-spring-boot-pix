package io.github.rodrigojfagundes.paymentsystem.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rodrigojfagundes.paymentsystem.dto.UserCreateRequest;
import io.github.rodrigojfagundes.paymentsystem.dto.UserResponse;
import io.github.rodrigojfagundes.paymentsystem.entity.User;
import io.github.rodrigojfagundes.paymentsystem.service.TokenService;
import io.github.rodrigojfagundes.paymentsystem.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid 
    		UserCreateRequest userCreateRequest) throws MessagingException, UnsupportedEncodingException {

    	User user = userCreateRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        
        return ResponseEntity.ok().body(userSaved);
    }
   
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    @GetMapping("/teste")
    public String teste(){
        return "você está logado";
    }

}
