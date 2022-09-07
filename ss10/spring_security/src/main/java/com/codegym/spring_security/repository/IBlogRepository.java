package com.codegym.spring_security.repository;

import com.codegym.spring_security.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingAndCategory_Id(String title, int categoryId, Pageable pageable);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

}
