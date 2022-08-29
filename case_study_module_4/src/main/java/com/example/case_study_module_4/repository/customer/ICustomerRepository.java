package com.example.case_study_module_4.repository.customer;

import com.example.case_study_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByNameContainingOrId(String name,Integer id, Pageable pageable);


}
