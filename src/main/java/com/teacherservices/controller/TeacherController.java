package com.teacherservices.controller;

import com.teacherservices.entity.Teacher;
import com.teacherservices.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ACCOUNTANT')")
    ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok().body(teacherService.Create(teacher));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ACCOUNTANT')")
    ResponseEntity<Teacher>getById(@PathVariable Long id){
        return ResponseEntity.ok().body(teacherService.getById(id));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ACCOUNTANT')")
    ResponseEntity<List<Teacher>>getAll(){
        return ResponseEntity.ok().body(teacherService.getAll());
    }
}
