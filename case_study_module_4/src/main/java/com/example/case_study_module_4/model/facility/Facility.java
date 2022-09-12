package com.example.case_study_module_4.model.facility;

import com.example.case_study_module_4.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dich_vu")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer id;

    @Column(name = "ten_dich_vu")
    private String name;

    @Column(name = "dien_tich")
    private String area;

    @Column(name = "chi_phi_thue",columnDefinition = "double")
    private String cost;

    @Column(name = "so_nguoi_toi_da",columnDefinition = "int")
    private String maxPeople;

    @Column(name = "tieu_chuan_phong")
    private String standardRoom;

    @Column(name = "mo_ta_tien_nghi_khac")
    private String otherConvenient;

    @Column(name = "dien_tich_ho_boi",columnDefinition = "double")
    private String poolArea;

    @Column(name = "so_tang",columnDefinition = "int")
    private String floors;

    @Column(name = "dich_vu_mien_phi_di_kem")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue",referencedColumnName = "ma_kieu_thue")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu",referencedColumnName = "ma_loai_dich_vu")
    private FacilityType facilityType;

    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private Set<Contract> contractSet;

}
