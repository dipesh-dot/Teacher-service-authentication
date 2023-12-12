package com.teacherservices.controller;

import com.teacherservices.entity.Role;
import com.teacherservices.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<Role> create(@RequestBody Role role){
        return ResponseEntity.ok().body(roleService.Create(role));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<Role>getById(@PathVariable Long id){
        return ResponseEntity.ok().body(roleService.getById(id));

    }
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<List<Role>> GetAll(){
        return ResponseEntity.ok().body(roleService.getAll());
    }

}
