package com.a2r.keycloakusersextension.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SimpleKeycloakUser {

    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private String myHobby;
}

