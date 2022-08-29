package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.Map;

public interface ICartService {

    void addProduct(Map<Product,Integer> cart, Product product);

    double getTotal(Map<Product,Integer> cart);
}
