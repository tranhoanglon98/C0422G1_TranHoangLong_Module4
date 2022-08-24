package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(String title, int categoryId, Pageable pageable) {
        if (categoryId == 0) {
            return blogRepository.findByTitleContaining(title, pageable);
        } else {
            return blogRepository.findByTitleContainingAndCategory_Id(title, categoryId, pageable);
        }
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Blog> findById(int id) {
        return this.blogRepository.findById(id);
    }
}
