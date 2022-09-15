package com.example.module_4_test.controller;

import com.example.module_4_test.model.TestClass;
import com.example.module_4_test.service.IService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private IService service;


    @GetMapping("/")
    public String goToHomePage(){
        return "home";
    }

    @GetMapping("/list")
    public String goToListPage(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("list",service.findAll(pageable));
        return "list";
    }

    @GetMapping("/add")
    public String goToAddPage(Model model){
        model.addAttribute("test", new TestClass());
        return "add";
    }
}
