package com.damian.application.liblary.service;

import com.damian.application.liblary.infrastucture.entity.AuthEntity;
import com.damian.application.liblary.infrastucture.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private long tokenLifeTime = 1000 * 60 * 24;

    @Value("${token.signing.key}")
    public String jwtSigningKey;

    public JwtService() {
    }

    public String generateToken(AuthEntity userDetail) {
        return generateToken(new HashMap<>(), userDetail);
    }

    public boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractClaims();
    }
    private <T> T extractClaims(String token, Function<Claims, T>)

    private boolean verify(String token) {
        return true;
    }

    private boolean isTokenValid(String token) {
        verify(token);
        isTokenExpired(token);

        return true;
    }


    public String generateToken(Map<String, Object> extraClaims, AuthEntity userDetails) {
        extraClaims.put("role", userDetails.getRole());
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt((new Date(System.currentTimeMillis())))
                .expiration(new Date(System.currentTimeMillis() * tokenLifeTime))
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
