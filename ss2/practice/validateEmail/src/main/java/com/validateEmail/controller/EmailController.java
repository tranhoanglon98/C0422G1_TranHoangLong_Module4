package com.validateEmail.controller;


import com.validateEmail.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/validate")
    public String validateEmail(@RequestParam String email, Model model){
        boolean result = iEmailService.validateEmail(email);
        if (result){
            model.addAttribute("result","Email is valid");
        }else {
            model.addAttribute("result","Email is invalid");
        }
        return "emailValidate";
    }

    @GetMapping("/")
    public String goEmailValidate(){
        return "emailValidate";
    }
}
