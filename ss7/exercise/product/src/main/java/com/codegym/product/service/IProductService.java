package com.codegym.product.service;


import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IProductService {

    Page<Product> findByName(String name, Pageable pageable);

    void save(Product product);

    void delete(int id);

    Optional<Product> findById(int id);
}
