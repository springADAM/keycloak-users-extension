package com.a2r.keycloakusersextension.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    /**
     * your seperate user will be linked to keycloak user through id
     */

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String otherAttribute;

}
