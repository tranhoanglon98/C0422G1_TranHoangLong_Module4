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
@Table(name = "kieu_thue")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private Integer id;

    @Column(name = "ten_kieu_thue")
    private String name;

    @OneToMany(mappedBy = "rentType")
    private List<Facility> facilityList;

}