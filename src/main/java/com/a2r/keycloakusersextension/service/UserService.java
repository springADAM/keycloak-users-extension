package com.a2r.keycloakusersextension.service;

import com.a2r.keycloakusersextension.entity.User;
import com.a2r.keycloakusersextension.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }
}
