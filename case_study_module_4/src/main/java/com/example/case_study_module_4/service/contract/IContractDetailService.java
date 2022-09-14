package com.example.case_study_module_4.service.contract;

import com.example.case_study_module_4.dto.IContractDetailDto;
import com.example.case_study_module_4.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();

    List<ContractDetail> findByContractId(Integer id);

    void saveAll(List<ContractDetail> contractDetailList);

    void save(ContractDetail contractDetail);

    List<IContractDetailDto> findAllContractDetailByContractId(Integer id);
}
