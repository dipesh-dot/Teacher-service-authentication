package com.teacherservices.repository;

import com.teacherservices.entity.Teacher_Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRoleRepository extends JpaRepository<Teacher_Roles,Long> {
}
