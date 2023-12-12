package com.teacherservices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_tb_seq_gen")
    @SequenceGenerator(name = "role_tb_seq_gen", sequenceName = "role_seq_gen",allocationSize = 1)
    private Long id;
    private String name;
    private boolean isActive;

}

