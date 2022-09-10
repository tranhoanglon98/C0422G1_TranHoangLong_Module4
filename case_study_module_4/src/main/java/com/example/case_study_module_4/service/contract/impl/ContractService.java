package com.example.case_study_module_4.service.contract.impl;

import com.example.case_study_module_4.model.contract.Contract;
import com.example.case_study_module_4.repository.Contract.IContractRepository;
import com.example.case_study_module_4.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.contractRepository.findAll(pageable);
    }
}
