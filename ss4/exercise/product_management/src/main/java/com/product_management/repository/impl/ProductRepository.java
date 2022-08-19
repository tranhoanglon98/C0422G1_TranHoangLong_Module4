package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        Product product1 = new Product((int) (Math.random() * 1000),
                "Áo", "500000", "màu đỏ", "Nike");
        Product product2 = new Product((int) (Math.random() * 1000),
                "Quần", "700000", "màu đen", "Adidas");
        Product product3 = new Product((int) (Math.random() * 1000),
                "Dép", "200000", "màu xanh lá chuối dương", "Lào");

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);
        productMap.put(product3.getId(), product3);
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        int id = (int) (Math.random() * 1000);
        product.setId(id);
        productMap.put(id, product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
