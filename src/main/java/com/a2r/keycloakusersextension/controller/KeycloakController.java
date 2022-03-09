package com.a2r.keycloakusersextension.controller;

import com.a2r.keycloakusersextension.dto.SimpleKeycloakUser;
import com.a2r.keycloakusersextension.entity.User;
import com.a2r.keycloakusersextension.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/register")
public class KeycloakController {

    private final KeycloakService keycloakService;

    @Autowired
    public KeycloakController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }


    @PostMapping
    public Mono<User> createUser(@Valid @RequestBody Mono<SimpleKeycloakUser> simpleKeycloakUserMono) {
        return simpleKeycloakUserMono.flatMap(keycloakService::createUserInKeycloakAndConvertToUser);
    }

    @GetMapping
    public Flux<User> findAllUsers() {
        return keycloakService.findAllUsers();
    }

}
