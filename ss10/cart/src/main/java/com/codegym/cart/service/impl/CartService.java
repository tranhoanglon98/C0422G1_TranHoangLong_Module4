package com.codegym.cart.service.impl;

import com.codegym.cart.model.Product;
import com.codegym.cart.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {

    @Override
    public void addProduct(Map<Product,Integer> cart,Product product) {
        if (cart.containsKey(product)){
            cart.put(product,cart.get(product) + 1);
        }else {
            cart.put(product,1);
        }
    }

    @Override
    public double getTotal(Map<Product,Integer> cart) {
        double total = 0;
        for (Product p : cart.keySet()){
            total += p.getPrice()*cart.get(p);
        }
        return total;
    }


}
