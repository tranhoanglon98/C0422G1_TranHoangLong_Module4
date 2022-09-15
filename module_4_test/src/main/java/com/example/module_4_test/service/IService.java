package com.example.module_4_test.service;

import com.example.module_4_test.model.TestClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {

    Page<TestClass> findAll(Pageable pageable);
}
