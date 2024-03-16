package com.damian.application.liblary.controller;

import com.damian.application.liblary.infrastucture.entity.UserEntity;
import com.damian.application.liblary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){

        return userService.getAll();
    }

    @GetMapping("{user_id}")
    public UserEntity getOne(@PathVariable long user_id){
        return userService.getOne(user_id);
    }

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity user){
        var newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @DeleteMapping("{user_id}")
    public ResponseEntity<Void> delete(@PathVariable long user_id){
        userService.delete(user_id);
        return ResponseEntity.noContent().build();
    }
}
