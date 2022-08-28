package com.example.case_study_module_4.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Facility> facilityList;
}
