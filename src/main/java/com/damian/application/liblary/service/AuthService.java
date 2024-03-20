package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.UserDTO.RegisterDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterResponseDto;
import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;
import com.damian.application.liblary.infrastucture.repository.AuthRepository;
import com.damian.application.liblary.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
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

        return new RegisterResponseDto(createAuth.getUsername(), createAuth.getRole())
    }
}
