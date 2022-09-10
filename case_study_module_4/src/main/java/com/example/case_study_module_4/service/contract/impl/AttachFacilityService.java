package com.example.case_study_module_4.service.contract.impl;

import com.example.case_study_module_4.model.contract.AttachFacility;
import com.example.case_study_module_4.repository.Contract.IAttachFacilityRepository;
import com.example.case_study_module_4.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return this.attachFacilityRepository.findAll();
    }
}
