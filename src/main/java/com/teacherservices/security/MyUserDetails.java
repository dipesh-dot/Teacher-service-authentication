package com.teacherservices.security;

import com.teacherservices.entity.Teacher;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String email;
    private String password;

    @Getter
    private String name;
    private boolean isActive;

    private List<? extends GrantedAuthority> authorities;


    MyUserDetails(Teacher teacher) {
        this.email = teacher.getEmail();
        this.name = teacher.getName();
        this.password = teacher.getPassword();
        this.isActive = teacher.isActive();
        this.authorities = Arrays.stream(getRoles(teacher).split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public String getRoles(Teacher teacher) {

        if (teacher.getRoles() == null || teacher.getRoles().isEmpty())
            return "ROLE_ADMIN";

        return teacher.getRoles().stream().map(x -> "ROLE_"+x.getRole().getName()).collect(Collectors.joining(","));
    }
}
