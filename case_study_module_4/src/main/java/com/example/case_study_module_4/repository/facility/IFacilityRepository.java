package com.example.case_study_module_4.repository.facility;

import com.example.case_study_module_4.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
}
