package com.codegym.cart.controller;


import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import com.codegym.cart.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> createCart() {
        return new HashMap<>();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String goProductList(Model model) {

        model.addAttribute("productList", this.productService.findAll());

        return "list";
    }

    @GetMapping("detail")
    public String goDetailPage(Model model, @RequestParam Integer id) {
        model.addAttribute("product", this.productService.findById(id));
        return "detail";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam Integer id,
                             @SessionAttribute("cart") Map<Product, Integer> cart) {

        Product product = this.productService.findById(id);
        this.cartService.addProduct(cart, product);

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute("cart") Map<Product, Integer> cart) {
        double total = this.cartService.getTotal(cart);
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart";
    }


}
