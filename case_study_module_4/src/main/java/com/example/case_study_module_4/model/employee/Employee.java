package com.example.case_study_module_4.model.employee;

import com.example.case_study_module_4.model.contract.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "nhan_vien")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer id;

    @Column(name = "ho_ten")
    private String name;

    @Column(name = "ngay_sinh",columnDefinition = "date")
    private String dayOfBirth;

    @Column(name = "so_cmnd")
    private String idCard;

    @Column(name = "luong",columnDefinition = "double")
    private String salary;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String dia_chi;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri",referencedColumnName = "ma_vi_tri")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan",referencedColumnName = "ma_bo_phan")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do",referencedColumnName = "ma_trinh_do")
    private EducationDegree educationDegree;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;
}
