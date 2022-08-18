package com.product_management.service.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void add(Product product) {
        this.iProductRepository.add(product);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        this.iProductRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.iProductRepository.findByName(name);
    }
}
