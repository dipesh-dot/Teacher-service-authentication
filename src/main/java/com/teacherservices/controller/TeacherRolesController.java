package com.teacherservices.controller;

import com.teacherservices.entity.Teacher_Roles;
import com.teacherservices.service.TeacherRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachersroles")
public class TeacherRolesController {

    private final TeacherRoleService teacherRoleService;

    public TeacherRolesController(TeacherRoleService teacherRoleService) {
        this.teacherRoleService = teacherRoleService;
    }

@PostMapping("/save")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
ResponseEntity<Teacher_Roles>create (@RequestBody Teacher_Roles teacherRoles){
        return ResponseEntity.ok().body(teacherRoleService.create(teacherRoles));

}

@GetMapping("/all")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
ResponseEntity<List<Teacher_Roles>>getall(){
        return ResponseEntity.ok().body(teacherRoleService.getAll());
}

@GetMapping("/{id}")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<Teacher_Roles>getById(@PathVariable Long id){
        return ResponseEntity.ok().body(teacherRoleService.getById(id));
    }


}