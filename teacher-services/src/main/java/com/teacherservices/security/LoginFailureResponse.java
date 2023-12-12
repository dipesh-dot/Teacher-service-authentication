package com.teacherservices.security;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginFailureResponse {
    public  boolean success;
    public String message;
}
