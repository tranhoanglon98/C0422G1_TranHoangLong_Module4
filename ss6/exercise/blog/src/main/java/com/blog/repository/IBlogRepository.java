package com.blog.repository;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {

    List<Blog> findAll();

    void save(Blog blog);

    void delete(int id);

    Blog findById(int id);
}
