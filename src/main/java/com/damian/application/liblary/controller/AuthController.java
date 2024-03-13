package com.damian.application.liblary.controller;


import com.damian.application.liblary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/signin")
    public void signIn(){

    }
    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponseDto> signUp(@RequestBody CreateUserDto user){
        var newUser = userService.create(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
