package com.teacherservices.security;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginSuccessResponse {
    public boolean success;
    public String token;
    public String name;
}
