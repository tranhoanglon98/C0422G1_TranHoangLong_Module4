package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.Categories;
import com.example.restful_blog.repository.ICategoryRepository;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Categories> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
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
