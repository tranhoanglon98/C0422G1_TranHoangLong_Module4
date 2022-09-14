package com.example.case_study_module_4.service.Employee.impl;

import com.example.case_study_module_4.model.employee.Employee;
import com.example.case_study_module_4.repository.Employee.IEmployeeRepository;
import com.example.case_study_module_4.service.Employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getListAllEmployee() {
        return this.employeeRepository.findAll();
    }
}
