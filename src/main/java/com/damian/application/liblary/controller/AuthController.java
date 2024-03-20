package com.damian.application.liblary.controller;



import com.damian.application.liblary.DTOs.UserDTO.RegisterDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterResponseDto;
import com.damian.application.liblary.DTOs.UserDTO.registerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping
    public ResponseEntity<RegisterResponseDto> register (@RequestBody RegisterDto requestBody){


        return null;
    }

}
