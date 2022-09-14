package com.example.case_study_module_4.service.facility;

import com.example.case_study_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {

    Page<Facility> findByName(String searchValue, Pageable pageable);

    List<Facility> getListAllFacility();

    void save(Facility facility);

    void delete(Integer id);

    Facility findById(Integer id);

}
