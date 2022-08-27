package com.example.case_study_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {

    @GetMapping("/")
    public String goHomePage(){
        return "home";
    }

    @GetMapping("/facility")
    public String goFacilityPage(){
        return "facility/list";
    }

    @GetMapping("/customer")
    public String goCustomerPage(){
        return "customer/list";
    }

    @GetMapping("/employee")
    public String goEmployeePage(){
        return "employee/list";
    }

    @GetMapping("/contract")
    public String goContractPage(){
        return "contract/list";
    }
}
