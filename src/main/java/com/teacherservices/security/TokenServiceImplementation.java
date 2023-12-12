package com.teacherservices.security;

import com.teacherservices.utils.SecurityUtilsConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImplementation implements TokenService {

    Map<String, AuthToken> map = new HashMap<>();

    public AuthToken generateNewToken(String username) {
        AuthToken authToken = new AuthToken();
        authToken.setLocalDateTime(LocalDateTime.now());
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(SecurityUtilsConstant.EXPIRE_TIME + System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, SecurityUtilsConstant.SECRET)
                .compact();
        authToken.setToken(SecurityUtilsConstant.TOKEN_PREFIX+token);
        return authToken;
    }

    @Override
    public String getTokenByAuth(Authentication authentication) {

        String token = authentication.getName();
        AuthToken authToken = generateNewToken(token);
        authToken.setAuthentication(authentication);
        map.put(authToken.getToken(), authToken);
       return authToken.getToken();
    }

    @Override
    public Authentication getAuthByToken(String token) {

        AuthToken authToken = map.getOrDefault(token, new AuthToken());

        return !authToken.isExpired() ? authToken.getAuthentication() : null;
    }
}
