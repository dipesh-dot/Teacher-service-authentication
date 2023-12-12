package com.teacherservices.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    public String getTokenByAuth(Authentication authentication);
    public  Authentication getAuthByToken(String token);
}
