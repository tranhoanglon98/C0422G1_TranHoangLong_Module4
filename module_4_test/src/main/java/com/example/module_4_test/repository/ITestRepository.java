package com.example.module_4_test.repository;

import com.example.module_4_test.model.TestClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestRepository extends JpaRepository<TestClass,Integer> {
}
