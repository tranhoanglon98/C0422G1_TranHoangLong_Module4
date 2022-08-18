package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String goListPage(Model model) {
        model.addAttribute("productList", this.iProductService.findAll());
        return "product_list";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam int id) {
        this.iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/addPage")
    public String goAddPage(Model model) {
        model.addAttribute("product", new Product());
        return "add_new_product";
    }

    @PostMapping("/add")
    public String saveAdd(@ModelAttribute Product product) {
        this.iProductService.add(product);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String goUpdatePage(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "update_product";
    }

    @PostMapping("/saveUpdate")
    public String update(@ModelAttribute Product product) {
        this.iProductService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String productName, Model model) {
        model.addAttribute("productList", this.iProductService.findByName(productName));
        return "product_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/product_detail";
    }
}
