package com.userauthapi.userauth.repository;

import com.userauthapi.userauth.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
