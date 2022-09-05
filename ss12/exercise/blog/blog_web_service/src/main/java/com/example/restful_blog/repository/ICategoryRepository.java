package com.example.restful_blog.repository;

import com.example.restful_blog.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories,Integer> {
}
