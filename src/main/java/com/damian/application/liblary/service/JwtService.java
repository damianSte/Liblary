package com.damian.application.liblary.service;

import com.damian.application.liblary.infrastucture.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtService {
    @Value("${token.sign.key")
    private String jwtSigningKey;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //TODO "need to create class UserEntity and User Service"
    public String generateToken(UserEntity userEntity) {
        return generateToken(new HashMap<>(), userEntity);
    }

    public boolean isTokenValid(String token, UserEntity userEntity) {
        try {
            final String userName = extractUsername(token);
            return !userName.isEmpty()&& !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private String generateToken(Map<String, Object> extraClaims, UserEntity userEntity) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userEntity.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey())
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
