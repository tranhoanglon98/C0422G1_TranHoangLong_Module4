package com.example.case_study_module_4.repository.facility;

import com.example.case_study_module_4.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
