package com.a2r.keycloakusersextension.service;

import com.a2r.keycloakusersextension.dto.SimpleKeycloakUser;
import com.a2r.keycloakusersextension.entity.User;
import com.a2r.keycloakusersextension.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Slf4j
@Service
public class KeycloakService {

    @Value("${realm}")
    private String realm;

    private final Keycloak instance;
    private final UserService usersService;
    private final EntityDtoUtil entityDtoUtil;

    @Autowired
    public KeycloakService(Keycloak instance, UserService usersService, EntityDtoUtil entityDtoUtil) {
        this.instance = instance;
        this.usersService = usersService;
        this.entityDtoUtil = entityDtoUtil;
    }


    public Mono<User> createUserInKeycloakAndConvertToUser(SimpleKeycloakUser simpleKeycloakUser) {

        UserRepresentation user = new UserRepresentation();
        user.setUsername(simpleKeycloakUser.getUsername());
        user.setFirstName(simpleKeycloakUser.getFirstName());
        user.setLastName(simpleKeycloakUser.getLastName());
        user.setEmail(simpleKeycloakUser.getEmail());
        user.setEnabled(true);
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType("password");
        credentialRepresentation.setValue(simpleKeycloakUser.getPassword());
        credentialRepresentation.setTemporary(false);
        user.setCredentials(Collections.singletonList(credentialRepresentation));

        Response response = instance.realm(realm).users().create(user);

        log.info("Response |  Status: {} | Status Info: {}", response.getStatus(), response.getStatusInfo());
        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        simpleKeycloakUser.setId(userId);
        return usersService.saveUser(entityDtoUtil.mapSimpleKeycloakToUser(simpleKeycloakUser));

    }

    public Flux<User> findAllUsers() {
        return usersService.findAllUsers();
    }
}
