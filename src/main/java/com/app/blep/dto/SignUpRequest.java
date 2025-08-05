package com.app.blep.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String passwordhash;
    private String email;
}
