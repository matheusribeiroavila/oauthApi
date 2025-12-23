package com.userauthapi.userauth.service;

import com.userauthapi.userauth.dto.UserDto;
import com.userauthapi.userauth.exception.NotFoundException;
import com.userauthapi.userauth.exception.UnauthorizedUserException;
import com.userauthapi.userauth.model.User;
import com.userauthapi.userauth.repository.UserRepository;
import com.userauthapi.userauth.security.MyToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User id ["+id+"] was not found."));
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Username ["+username+"] was not found."));
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(UserDto user) {
        User userTarget = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        userTarget.setUsername(user.username());
        userTarget.setPassword(encoder.encode(user.password()));

        return userRepository.save(userTarget);
    }

    @Override
    public MyToken userLogin(UserDto user) {
        User storedUser = userRepository.findByUsername(user.username()).orElseThrow(() -> new UnauthorizedUserException("Unauthorized access, user not found."));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(encoder.matches(user.password(), storedUser.getPassword())){
            return new MyToken("security123");
        }

        throw new UnauthorizedUserException("Unauthorized access");
    }
}
