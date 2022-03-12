package com.a2r.keycloakusersextension.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SimpleKeycloakUser {

    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    // add any other attributes that you want to be separated from keycloak
    private String otherAttribute;
}

