package com.example.case_study_module_4.repository.Employee;

import com.example.case_study_module_4.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
