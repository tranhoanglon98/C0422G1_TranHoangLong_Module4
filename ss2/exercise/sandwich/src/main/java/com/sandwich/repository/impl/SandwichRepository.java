package com.sandwich.repository.impl;

import com.sandwich.repository.ISandwichRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichRepository implements ISandwichRepository {
    private static List<String> condiments = new ArrayList<>();

    static {
        condiments.add("Lettuce");
        condiments.add("Tomato");
        condiments.add("Mustard");
        condiments.add("Sprouts");
    }

    @Override
    public List<String> findAllCondiments() {
        return condiments;
    }
}
