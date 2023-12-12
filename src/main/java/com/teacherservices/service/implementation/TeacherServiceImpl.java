package com.teacherservices.service.implementation;

import com.teacherservices.entity.Teacher;
import com.teacherservices.repository.TeacherRepository;
import com.teacherservices.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher Create(Teacher teacher) {
        teacher.setPassword(BCrypt.hashpw(teacher.getPassword(),BCrypt.gensalt()));
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User doest found"));

    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
