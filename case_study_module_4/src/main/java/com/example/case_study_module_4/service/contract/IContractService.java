package com.example.case_study_module_4.service.contract;

import com.example.case_study_module_4.dto.ContractDto;
import com.example.case_study_module_4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<ContractDto> findAll(Pageable pageable);

    Page<ContractDto> findInvalidContract(String now,Pageable pageable);

    void save(Contract contract);

    Contract findLastContract();
}
