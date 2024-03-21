package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.UserDTO.LogInDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterResponseDto;
import com.damian.application.liblary.DTOs.UserDTO.LogInResponseDto;
import com.damian.application.liblary.UserRole;
import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;
import com.damian.application.liblary.infrastucture.repository.AuthRepository;
import com.damian.application.liblary.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public RegisterResponseDto register(RegisterDto registerDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerDto.getEmail());
        UserEntity createdUser = userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(registerDto.getPassword());
        authEntity.setUsername(registerDto.getUsername());
        authEntity.setRole(registerDto.getRole());
        authEntity.setUser(createdUser);

        AuthEntity createAuth = authRepository.save(authEntity);

        return new RegisterResponseDto(createAuth.getUsername(), createAuth.getRole());
    }

    public LogInResponseDto login (LogInDto logInDto) {
        AuthEntity authEntity = authRepository.findByUserName(logInDto.getUsername()).orElseThrow(RuntimeException::new);
        if (!authEntity.getPassword().equals(logInDto.getPassword())){
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(authEntity);

        UserRole userRole = jwtService.extractUserRole(token);

        return new LogInResponseDto(userRole.name());
    }

}
