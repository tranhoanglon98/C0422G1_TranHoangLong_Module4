package com.example.restful_blog.controller;

import com.example.restful_blog.dto.BlogDto;
import com.example.restful_blog.model.Blog;
import com.example.restful_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> goHome(
                                 @PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "0") int categoryId) {
        Page<Blog> blogPage = this.blogService.findAll(categoryId, pageable);
        if (blogPage.hasContent()){
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Map<String,String>> add(@RequestBody @Valid BlogDto blogDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            Map<String,String> err = new HashMap<>();
            for (FieldError f :  bindingResult.getFieldErrors()){
                err.put(f.getField(),f.getDefaultMessage());
            }
            return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        this.blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> goDetail(@RequestParam int id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
