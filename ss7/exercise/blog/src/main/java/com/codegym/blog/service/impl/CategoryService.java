package com.codegym.blog.service.impl;

import com.codegym.blog.model.Categories;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Categories> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Categories> findById(int id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public void save(Categories categories) {
        this.categoryRepository.save(categories);
    }
}
