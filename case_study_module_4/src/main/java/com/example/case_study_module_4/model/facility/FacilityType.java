package com.example.case_study_module_4.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private Integer id;

    @Column(name = "ten_loai_dich_vu")
    private String name;

    @OneToMany(mappedBy = "facilityType")
    @JsonBackReference
    private List<Facility> facilityList;
}
