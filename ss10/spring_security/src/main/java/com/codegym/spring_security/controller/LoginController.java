package com.codegym.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping
    public String getHomePage(){
        return "login/home";
    }

    @GetMapping("/showLogin")
    public String showLogin(Model model){
        model.addAttribute("show","showLogin");
        return "/login/home";
    }
}
