package com.app.blep.controller;

import com.app.blep.dto.LoginRequest;
import com.app.blep.model.Users;
import com.app.blep.service.UsersService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
            String token = generateToken(findByUsername(request.getUsername()));
            System.out.println("inside ");
            return findByUsername(request.getUsername());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody LoginRequest signUpRequest) {
        System.out.println(" in sign up");
        Users newUser = usersService.signUpUser(signUpRequest.getUsername(), signUpRequest.getPassword());
        if ( newUser != null) {
            return "Signup is successful. You can now log in!";
        } else {
            return " Please try a different username";
        }
    }

    private String generateToken(String userName) {
        // TODO: update with real token generation
        return "brainorbrawn";
    }

    private String findByUsername(String username) {
        Optional<Users> user = usersService.findUserByName(username);
        if (user.isPresent()) {
            return user.get().getUsername();
        } else {
            return "Username not found";
        }
    }
}
