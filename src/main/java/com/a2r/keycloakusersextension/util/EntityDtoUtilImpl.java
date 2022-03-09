package com.a2r.keycloakusersextension.util;

import com.a2r.keycloakusersextension.dto.SimpleKeycloakUser;
import com.a2r.keycloakusersextension.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoUtilImpl implements EntityDtoUtil{

    @Override
    public User mapSimpleKeycloakToUser(SimpleKeycloakUser simpleKeycloakUser) {
        User user = new User();
        BeanUtils.copyProperties(simpleKeycloakUser,user);
        user.setNom(simpleKeycloakUser.getFirstName());
        user.setPrenom(simpleKeycloakUser.getLastName());
        return user;
    }
}
