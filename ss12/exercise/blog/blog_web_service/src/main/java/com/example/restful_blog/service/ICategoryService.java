package com.example.restful_blog.service;

import com.example.restful_blog.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Page<Categories> findAll(Pageable pageable);

    void delete(int id);

    Optional<Categories> findById(int id);

    void save(Categories categories);
}
