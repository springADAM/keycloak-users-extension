package com.a2r.keycloakusersextension.repository;

import com.a2r.keycloakusersextension.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,String> {
}
