package com.teacherservices.service;

import com.teacherservices.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher Create(Teacher teacher );
    Teacher getById(Long id);
    List<Teacher>getAll();
}
