package com.teacherservices.security;

import com.teacherservices.utils.SecurityUtilsConstant;
import lombok.*;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthToken {
    public Authentication authentication;
    public String token;
    public LocalDateTime localDateTime;


    public boolean isExpired(){
        return localDateTime.plusSeconds(SecurityUtilsConstant.EXPIRE_TIME/1000).isBefore(LocalDateTime.now());
    }

    public void renew(){
        localDateTime = LocalDateTime.now();
    }
}
