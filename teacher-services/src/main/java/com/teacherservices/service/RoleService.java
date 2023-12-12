package com.teacherservices.service;

import com.teacherservices.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role Create(Role role);
    Role getById(Long id);
    List<Role>getAll();
}
