package com.teacherservices.service.implementation;

import com.teacherservices.entity.Teacher_Roles;
import com.teacherservices.repository.TeacherRoleRepository;
import com.teacherservices.service.TeacherRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherRoleImpl implements TeacherRoleService {

    private final TeacherRoleRepository teacherRoleRepository;

    public TeacherRoleImpl(TeacherRoleRepository teacherRoleRepository) {
        this.teacherRoleRepository = teacherRoleRepository;
    }

    @Override
    public Teacher_Roles create(Teacher_Roles teacherRoles) {
        return teacherRoleRepository.save(teacherRoles);
    }

    @Override
    public List<Teacher_Roles> getAll() {
        return teacherRoleRepository.findAll();
    }


    @Override
    public Teacher_Roles getById(Long id) {
        return teacherRoleRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Teacher role with id not found"+id));
    }
}
