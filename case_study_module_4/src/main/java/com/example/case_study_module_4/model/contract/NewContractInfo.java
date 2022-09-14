package com.example.case_study_module_4.model.contract;

import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.model.employee.Employee;
import com.example.case_study_module_4.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class NewContractInfo {

    private List<Facility> facility;

    private List<Customer> customer;

    private List<Employee> employee;

    private List<AttachFacility> attachFacility;
}
