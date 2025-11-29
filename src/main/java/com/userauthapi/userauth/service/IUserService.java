package com.userauthapi.userauth.service;

import com.userauthapi.userauth.dto.UserDto;
import com.userauthapi.userauth.model.User;

import java.util.List;

public interface IUserService {
    public User findUserById(Integer id);
    public User findByUserName(String username);
    public List<User> findAllUser();
    public User createNewUser(UserDto user);
}
