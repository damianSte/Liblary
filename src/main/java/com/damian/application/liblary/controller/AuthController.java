package com.damian.application.liblary.controller;


import com.damian.application.liblary.DTOs.UserDTO.LogInDto;
import com.damian.application.liblary.DTOs.UserDTO.LogInResponseDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterResponseDto;
import com.damian.application.liblary.service.AuthService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@PreAuthorize("hasRole('ADMIN')")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterDto requestBody) {
        RegisterResponseDto registerResponseDto = authService.register(requestBody);

        return new ResponseEntity<>(registerResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LogInResponseDto> login(@RequestBody LogInDto requestBody) {

       LogInResponseDto dto = authService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
