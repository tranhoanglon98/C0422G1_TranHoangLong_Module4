package com.example.case_study_module_4.repository.Contract;

import com.example.case_study_module_4.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
