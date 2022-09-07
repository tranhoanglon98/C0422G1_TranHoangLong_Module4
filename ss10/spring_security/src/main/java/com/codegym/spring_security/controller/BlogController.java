package com.codegym.spring_security.controller;

import com.codegym.spring_security.model.Blog;
import com.codegym.spring_security.service.IBlogService;
import com.codegym.spring_security.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String goHome(Model model,
                         @PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam(required = false, defaultValue = "") String titleSearch,
                         @RequestParam(required = false, defaultValue = "0") int categorySearch){
        Page<Blog> blogPage = this.blogService.findAll(titleSearch, categorySearch, pageable);
        model.addAttribute("blogs", blogPage);
        model.addAttribute("categories", this.categoryService.findAll());
        model.addAttribute("titleSearch", titleSearch);
        model.addAttribute("categorySearch", categorySearch);
        if (blogPage.getTotalPages() > 0) {
            int[] pageNumber = new int[blogPage.getTotalPages()];
            model.addAttribute("pageNumber", pageNumber);
        }

        return "/blog/home";
    }

    @GetMapping("add")
    public String goAdd(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", this.categoryService.findAll());
        return "/blog/add";
    }

    @PostMapping("save")
    public String saveBlog(@ModelAttribute Blog blog) {
        this.blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String goUpdate(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", this.blogService.findById(id).get());
        model.addAttribute("categories", this.categoryService.findAll());
        return "/blog/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        this.blogService.delete(id);
        return "redirect:";
    }

    @GetMapping("detail")
    public String goDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.blogService.findById(id).get());
        return "/blog/detail";
    }

}
