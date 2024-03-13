package com.damian.application.liblary.service;

import org.springframework.beans.factory.annotation.Value;

public class JwtService {
    @Value("${token.sign.key")
    private String signingKey;
}
