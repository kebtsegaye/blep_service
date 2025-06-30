package com.app.blep.controller;

import com.app.blep.dto.LoginRequest;
import com.app.blep.dto.SignUpRequest;
import com.app.blep.model.Users;
import com.app.blep.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest request) {
            // String token = generateToken(findByUsername(request.getUsername()));
            System.out.println("inside ");
            if (request.getUsername().equals("keb")) {
                return ResponseEntity.ok(request);
            } else {
                return ResponseEntity.badRequest().body(request);
            }
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody SignUpRequest signUpRequest) {
        System.out.println(" in sign up");
        Users newUser = usersService.addUser(signUpRequest.getUsername(), signUpRequest.getPasswordhash(),
                signUpRequest.getEmail());
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
