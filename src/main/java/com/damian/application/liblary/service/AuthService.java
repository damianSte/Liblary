package com.damian.application.liblary.service;

import com.damian.application.liblary.DTOs.UserDTO.LogInDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterDto;
import com.damian.application.liblary.DTOs.UserDTO.RegisterResponseDto;
import com.damian.application.liblary.DTOs.UserDTO.LogInResponseDto;
import com.damian.application.liblary.error.UserAlreadyExistsException;
import com.damian.application.liblary.error.UserNotFoundException;
import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;
import com.damian.application.liblary.infrastucture.repository.AuthRepository;
import com.damian.application.liblary.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDto register(RegisterDto registerDto) {

        Optional<AuthEntity> existingAuth = authRepository.findByUsername(registerDto.getUsername());

        if (existingAuth.isPresent()) {
            throw UserAlreadyExistsException.create(registerDto.getUsername());
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerDto.getEmail());
        userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        authEntity.setUsername(registerDto.getUsername());
        authEntity.setRole(registerDto.getRole());
        authEntity.setUser(userEntity);

        authRepository.save(authEntity);

        return new RegisterResponseDto(userEntity.getUser_id(), authEntity.getUsername(), authEntity.getRole());
    }

    public LogInResponseDto login(LogInDto logInDto) {

        Optional<AuthEntity> existingAuth = authRepository.findByUsername(logInDto.getUsername());

        if (existingAuth.isEmpty()) {
            throw UserNotFoundException.create(logInDto.getUsername());
        }

        AuthEntity authEntity = authRepository.findByUsername(logInDto.getUsername()).orElseThrow(RuntimeException::new);
        if (!passwordEncoder.matches(logInDto.getPassword(), authEntity.getPassword())) {
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(authEntity);

        return new LogInResponseDto(token);
    }

}
