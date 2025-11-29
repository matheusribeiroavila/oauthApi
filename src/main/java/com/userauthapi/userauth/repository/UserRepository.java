package com.userauthapi.userauth.repository;

import com.userauthapi.userauth.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Integer> {
    public User findByUsername(String username);
}
