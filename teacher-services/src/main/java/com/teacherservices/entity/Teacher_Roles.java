package com.teacherservices.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "teacher_roles_tb", uniqueConstraints = {@UniqueConstraint(columnNames = {"teacher_id","role_id"})})
public class Teacher_Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_role_tb_seq_gen")
    @SequenceGenerator(name = "teacher_role_tb_seq_gen",sequenceName = "teacher_role_tb_seq")
    private Long id;

    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    @JsonBackReference
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

}
