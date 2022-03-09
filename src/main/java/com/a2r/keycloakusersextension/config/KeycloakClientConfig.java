package com.a2r.keycloakusersextension.config;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KeycloakClientConfig {

    @Bean
    public Keycloak keycloak(@Value("${keycloak.server.url}") String serverUrl){
        return Keycloak.getInstance(serverUrl, "master", "admin", "admin","admin-cli");
    }

}
