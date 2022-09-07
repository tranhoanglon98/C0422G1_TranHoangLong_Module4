package com.codegym.spring_security.controller;

import com.codegym.spring_security.model.Categories;
import com.codegym.spring_security.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String goCategoryList(Model model) {
        model.addAttribute("categories", this.categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        this.categoryService.delete(id);
        return "redirect:/category/list";
    }

    @GetMapping("/add")
    public String goAdd(Model model) {
        model.addAttribute("category", new Categories());
        return "/category/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Categories categories) {
        this.categoryService.save(categories);
        return "redirect:/category/list";
    }

    @GetMapping("/edit")
    public String goEdit(@RequestParam int id, Model model) {
        model.addAttribute("category", this.categoryService.findById(id).get());
        return "category/edit";
    }

    @PostMapping("/edit/save")
    public String saveEdit(@ModelAttribute Categories categories) {
        this.categoryService.save(categories);
        return "redirect:/category/list";
    }
}
