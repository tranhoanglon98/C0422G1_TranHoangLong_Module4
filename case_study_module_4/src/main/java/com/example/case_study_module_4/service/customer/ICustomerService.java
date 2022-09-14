package com.example.case_study_module_4.service.customer;

import com.example.case_study_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findByName(String searchValue, Pageable pageable);
    Page<Customer> getUsingCustomer(String now,String searchValue, Pageable pageable);

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);

}
