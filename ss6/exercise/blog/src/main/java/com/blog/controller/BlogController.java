package com.blog.controller;


import com.blog.model.Blog;
import com.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("blogs",new Blog());
        return "home";
    }

    @GetMapping("/add")
    public String goAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "add";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam int id, Model model){
        model.addAttribute("blog", this.blogService.findById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        this.blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/detail";
    }
}
