package com.example.restful_blog.controller;

import com.example.restful_blog.model.Categories;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Categories>> goCategoryList(@PageableDefault(size = 5) Pageable pageable) {
            Page<Categories> categories = this.categoryService.findAll(pageable);
            if (categories.hasContent()){
                return  new ResponseEntity<>(categories, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
