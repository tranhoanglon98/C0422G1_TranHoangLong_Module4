package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.repository.IBlogRepository;
import com.example.restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(int categoryId, Pageable pageable) {
        if (categoryId == 0) {
            return this.blogRepository.findAll(pageable);
        }
        return this.blogRepository.findByCategory_Id(categoryId, pageable);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepository.delete(findById(id));
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }
}
