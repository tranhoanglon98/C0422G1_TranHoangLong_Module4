package com.example.case_study_module_4.model.contract;

import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.model.employee.Employee;
import com.example.case_study_module_4.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "hop_dong")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Integer id;

    @Column(name = "ngay_lam_hop_dong", columnDefinition = "date")
    private String startDay;

    @Column(name = "ngay_ket_thuc", columnDefinition = "date")
    private String endDay;

    @Column(name = "tien_dat_coc",columnDefinition = "double")
    private String deposit;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien",referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang",referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu",referencedColumnName = "ma_dich_vu")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private Set<ContractDetail> contractDetails;
}
