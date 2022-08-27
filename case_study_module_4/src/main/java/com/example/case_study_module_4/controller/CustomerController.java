package com.example.case_study_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/add")
    public String goCustomerAddPage(){
        return "customer/add";
    }

    @GetMapping("/update")
    public String goCustomerUpdatePage(){
        return "customer/update";
    }
}
