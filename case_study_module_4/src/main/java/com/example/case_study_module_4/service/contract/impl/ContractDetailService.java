package com.example.case_study_module_4.service.contract.impl;

import com.example.case_study_module_4.model.contract.ContractDetail;
import com.example.case_study_module_4.repository.Contract.IContractDetailRepository;
import com.example.case_study_module_4.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }
}
