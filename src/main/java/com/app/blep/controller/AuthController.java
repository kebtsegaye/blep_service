package com.app.blep.controller;

import com.app.blep.dto.LoginRequest;
import com.app.blep.model.Users;
import com.app.blep.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Users user = findByUsername(request.getUsername()).orElse(null);

        // TODO: Password is not hashed right now
        if (user != null && user.getPasswordHash().equals(request.getPassword())) {
            String token = generateToken(user.getUserName());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password. Please try again!");
        }
    }

    private String generateToken(String userName) {
        // TODO: update with real token generation
        return "brainorbrawn";
    }

    private Optional<Users> findByUsername(String username) {
        return usersService.findUserByName(username);
    }
}
