package com.example.case_study_module_4.service.facility.impl;

import com.example.case_study_module_4.model.facility.FacilityType;
import com.example.case_study_module_4.repository.facility.IFacilityTypeRepository;
import com.example.case_study_module_4.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return this.facilityTypeRepository.findAll();
    }
}
