package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll(String name);

    void add(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product findById(int id);

}
