package com.example.case_study_module_4.repository.Contract;

import com.example.case_study_module_4.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
