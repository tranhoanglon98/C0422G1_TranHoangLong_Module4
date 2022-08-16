package com.sandwich.controller;

import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService iSandwichService;

    @GetMapping("/")
    public String goSandwichPage(Model model) {
        model.addAttribute("condimentList", this.iSandwichService.findAllCondiments());
        return "sandwich";
    }

    @PostMapping("/condiments")
    public String chooseCondiments(@RequestParam(required = false) List<String> condiments, Model model) {
        model.addAttribute("condimentList", this.iSandwichService.findAllCondiments());
        if (condiments == null) {
            model.addAttribute("mess", "you haven't chosen any condiments yet!");
        } else {
            model.addAttribute("condiments", condiments);
        }
        return "sandwich";
    }
}
