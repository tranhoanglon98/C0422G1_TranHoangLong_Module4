package com.example.case_study_module_4.model.contract;


import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dich_vu_di_kem")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer id;

    @Column(name = "ten_dich_vu_di_kem")
    private String name;

    @Column(name = "gia",columnDefinition = "double")
    private String cost;

    @Column(name = "don_vi")
    private String unit;

    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    @JsonBackReference
    private Set<ContractDetail> contractDetails;
}
