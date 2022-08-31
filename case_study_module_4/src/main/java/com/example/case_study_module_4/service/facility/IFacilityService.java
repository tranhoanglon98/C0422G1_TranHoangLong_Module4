package com.example.case_study_module_4.service.facility;

import com.example.case_study_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findByNameOrId(String searchValue, Pageable pageable);

    void save(Facility facility);

    void delete(Integer id);

    Facility findById(Integer id);

}
