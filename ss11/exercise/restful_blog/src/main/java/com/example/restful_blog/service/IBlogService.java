package com.example.restful_blog.service;

import com.example.restful_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAll( int categoryId, Pageable pageable);

    void save(Blog blog);

    void delete(int id);

    Blog findById(int id);

}
