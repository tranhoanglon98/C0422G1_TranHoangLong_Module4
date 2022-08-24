package com.codegym.blog.repository;

import com.codegym.blog.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories,Integer> {
}
