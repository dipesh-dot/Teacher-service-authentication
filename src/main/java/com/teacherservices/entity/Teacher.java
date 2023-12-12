package com.teacherservices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Teacher_tb_seq_gen")
    @SequenceGenerator(name = "Teacher_tb_seq_gen",sequenceName = "Teacher_tb_seq",allocationSize = 1)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String password;
    private String name;
    private boolean isActive;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    Set<Teacher_Roles> roles;
}
