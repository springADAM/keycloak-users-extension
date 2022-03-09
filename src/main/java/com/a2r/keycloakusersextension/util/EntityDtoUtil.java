package com.a2r.keycloakusersextension.util;

import com.a2r.keycloakusersextension.dto.SimpleKeycloakUser;
import com.a2r.keycloakusersextension.entity.User;

@FunctionalInterface
public interface EntityDtoUtil {

    User mapSimpleKeycloakToUser(SimpleKeycloakUser simpleKeycloakUser);

}
