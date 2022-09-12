package com.example.case_study_module_4.service.facility.impl;

import com.example.case_study_module_4.model.facility.Facility;
import com.example.case_study_module_4.repository.facility.IFacilityRepository;
import com.example.case_study_module_4.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByName(String searchValue, Pageable pageable) {

        return this.facilityRepository.findByNameContaining(searchValue, pageable);
    }

    @Override
    public void save(Facility facility) {
        if (facility.getFacilityType().getId() != 1){
            facility.setPoolArea(null);
            if (facility.getFacilityType().getId() == 3){
                facility.setFloors(null);
            }
        }

        this.facilityRepository.save(facility);
    }

    @Override
    public void delete(Integer id) {
        this.facilityRepository.delete(findById(id));
    }

    @Override
    public Facility findById(Integer id) {
        return this.facilityRepository.findById(id).orElse(null);
    }
}
