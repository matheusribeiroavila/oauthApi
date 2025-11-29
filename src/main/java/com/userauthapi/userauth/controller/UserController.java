package com.userauthapi.userauth.controller;

import com.userauthapi.userauth.dto.UserDto;
import com.userauthapi.userauth.model.User;
import com.userauthapi.userauth.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<User> findUserByName(@PathVariable String username){
        return ResponseEntity.ok().body(userService.findByUserName(username));
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok().body(userService.findAllUser());
    }

    @PostMapping("/user")
    public ResponseEntity<User> createNewUser(@RequestBody UserDto dto){
        return ResponseEntity.status(201).body(userService.createNewUser(dto));
    }

}
