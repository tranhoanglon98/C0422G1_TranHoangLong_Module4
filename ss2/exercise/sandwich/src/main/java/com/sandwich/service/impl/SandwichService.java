package com.sandwich.service.impl;

import com.sandwich.repository.ISandwichRepository;
import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    private ISandwichRepository iSandwichRepository;

    @Override
    public List<String> findAllCondiments() {
        return this.iSandwichRepository.findAllCondiments();
    }
}
