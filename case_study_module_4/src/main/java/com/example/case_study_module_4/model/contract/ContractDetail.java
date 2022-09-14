package com.example.case_study_module_4.model.contract;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "hop_dong_chi_tiet")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer id;

    @Column(name = "so_luong",columnDefinition = "int")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong",referencedColumnName = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem",referencedColumnName = "ma_dich_vu_di_kem")
    private AttachFacility attachFacility;
}
