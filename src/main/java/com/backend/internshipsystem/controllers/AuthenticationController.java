package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.dto.AuthenticationDTO;
import com.backend.internshipsystem.domain.dto.LoginResponseDTO;
import com.backend.internshipsystem.domain.dto.RegisterAuthDTO;
import com.backend.internshipsystem.domain.entities.User;
import com.backend.internshipsystem.domain.repositories.UserRepository;
import com.backend.internshipsystem.infra.security.TokenService;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody @Valid AuthenticationDTO data){
        try{
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));

        }catch (Exception e) {
            System.out.println("Failed to authenticate user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed to authenticate user");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody @Valid RegisterAuthDTO data) {
        if (this.repository.findByLogin(data.login()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this login already exists");
        }
        try {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            User newUser = new User(data.login(), encryptedPassword, data.role());
            this.repository.save(newUser);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Failed to register user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
        }
    }
}
