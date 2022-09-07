package com.codegym.spring_security.service;

import com.codegym.spring_security.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface IBlogService {

    Page<Blog> findAll(String title, int categoryId, Pageable pageable);

    void save(Blog blog);

    void delete(int id);

    Optional<Blog> findById(int id);

}
