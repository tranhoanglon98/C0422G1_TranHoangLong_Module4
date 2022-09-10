package com.example.case_study_module_4.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "bo_phan")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private Integer id;

    @Column(name = "ten_bo_phan")
    private String department;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
