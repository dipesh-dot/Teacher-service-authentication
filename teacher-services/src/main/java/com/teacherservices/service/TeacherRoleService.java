package com.teacherservices.service;

import com.teacherservices.entity.Teacher_Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherRoleService {

Teacher_Roles create(Teacher_Roles teacherRoles);
List<Teacher_Roles> getAll();
Teacher_Roles getById(Long id);

}
