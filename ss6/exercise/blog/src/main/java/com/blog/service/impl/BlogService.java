package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.impl.BlogRepository;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepository.delete(id);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id);
    }
}
