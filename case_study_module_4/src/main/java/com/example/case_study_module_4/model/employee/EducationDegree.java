package com.example.case_study_module_4.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "trinh_do")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private Integer id;

    @Column(name = "ten_trinh_do")
    private String degree;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees;
}
