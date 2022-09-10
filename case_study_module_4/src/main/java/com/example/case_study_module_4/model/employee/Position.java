package com.example.case_study_module_4.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vi_tri")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer id;

    @Column(name = "ten_vi_tri")
    private String position;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;
}
