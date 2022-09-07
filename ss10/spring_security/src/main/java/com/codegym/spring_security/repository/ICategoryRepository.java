package com.codegym.spring_security.repository;

import com.codegym.spring_security.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories,Integer> {
}
