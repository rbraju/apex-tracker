package com.rbrcloud.portfoliosrvc.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    // Will be loaded from secure env variables in production
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token expiration: 24 hours
    private final long jwtExpirationMs = 86400000;

    public String generateJwtToken(String username) {
        Date currentDate = new Date();
        return Jwts.builder()
                .signWith(key)
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(new Date(currentDate.getTime() + jwtExpirationMs))
                .compact();
    }

    public String getUsernameGromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Log error
        }
        return false;
    }
}
