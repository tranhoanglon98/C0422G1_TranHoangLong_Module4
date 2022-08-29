package com.example.case_study_module_4.service.customer.impl;

import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.repository.customer.ICustomerRepository;
import com.example.case_study_module_4.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Page<Customer> findByNameOrId(String searchValue, Pageable pageable) {
        Integer id;
        try {
             id = Integer.parseInt(searchValue);
        }catch (Exception e){
            id = 0;
        }
        return this.customerRepository.findByNameContainingOrId(searchValue, id, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        this.customerRepository.delete(findById(id));
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
