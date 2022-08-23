package com.codegym.blog.service;


import com.codegym.blog.model.Blog;
import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    void delete(int id);

    Optional<Blog> findById(int id);

}
