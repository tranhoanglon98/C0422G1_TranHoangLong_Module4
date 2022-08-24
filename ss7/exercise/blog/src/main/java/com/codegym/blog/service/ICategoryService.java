package com.codegym.blog.service;

import com.codegym.blog.model.Categories;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Categories> findAll();

    void delete(int id);

    Optional<Categories> findById(int id);

    void save(Categories categories);
}
