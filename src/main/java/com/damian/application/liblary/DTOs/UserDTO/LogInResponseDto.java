package com.damian.application.liblary.DTOs.UserDTO;

public class LogInResponseDto {

    private String token;

    public LogInResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
