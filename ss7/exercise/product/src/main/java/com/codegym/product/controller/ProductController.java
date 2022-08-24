package com.codegym.product.controller;

import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String goListPage(@RequestParam(required = false, defaultValue = "") String productName,
                             @PageableDefault(size = 4) Pageable pageable,
                             Model model) {
        Page<Product> productPage = this.iProductService.findByName(productName, pageable);
        model.addAttribute("name", productName);
        model.addAttribute("productList", productPage);
        if (productPage.getTotalPages() > 0) {
            int[] pageNumber = new int[productPage.getTotalPages()];
            model.addAttribute("pageNumber", pageNumber);
        }
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
        this.iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String goUpdatePage(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "update_product";
    }

    @PostMapping("/saveUpdate")
    public String update(@ModelAttribute Product product) {
        this.iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/product_detail";
    }
}
