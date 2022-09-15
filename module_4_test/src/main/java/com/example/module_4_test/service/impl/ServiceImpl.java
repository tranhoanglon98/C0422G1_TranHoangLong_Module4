package com.example.module_4_test.service.impl;

import com.example.module_4_test.model.TestClass;
import com.example.module_4_test.repository.ITestRepository;
import com.example.module_4_test.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {

    @Autowired
    private ITestRepository testRepository;

    @Override
    public Page<TestClass> findAll(Pageable pageable) {
        return testRepository.findAll(pageable);
    }
}
