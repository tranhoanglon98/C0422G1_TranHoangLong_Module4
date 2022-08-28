package com.example.case_study_module_4.service.customer.impl;

import com.example.case_study_module_4.model.customer.CustomerType;
import com.example.case_study_module_4.repository.customer.ICustomerTypeRepository;
import com.example.case_study_module_4.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
