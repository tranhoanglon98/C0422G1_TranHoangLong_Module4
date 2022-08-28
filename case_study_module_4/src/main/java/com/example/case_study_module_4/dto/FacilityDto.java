package com.example.case_study_module_4.dto;

import com.example.case_study_module_4.model.facility.FacilityType;
import com.example.case_study_module_4.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto {

    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String otherConvenient;
    private Double poolArea;
    private Integer floors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;
}
