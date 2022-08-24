package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingAndCategory_Id(String title, int categoryId, Pageable pageable);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

}
