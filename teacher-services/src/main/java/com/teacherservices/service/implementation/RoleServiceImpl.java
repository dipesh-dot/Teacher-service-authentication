package com.teacherservices.service.implementation;

import com.teacherservices.entity.Role;
import com.teacherservices.repository.RoleRepository;
import com.teacherservices.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private  final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role Create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Role not found with id :"+id));
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
