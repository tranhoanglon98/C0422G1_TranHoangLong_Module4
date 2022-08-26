package com.codegym.user_form.controller;

import com.codegym.user_form.dto.UserDto;
import com.codegym.user_form.model.User;
import com.codegym.user_form.service.IUserService;
import com.codegym.user_form.util.UserValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class  UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable){
        model.addAttribute("users",this.userService.findAll(pageable));
        return "list";
    }

    @GetMapping("/add")
    public String goAddPage(Model model){
        model.addAttribute("userDto",new UserDto());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        new UserValidator().validate(userDto,bindingResult);

        if (bindingResult.hasErrors()){
                return "add";
            }

        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        this.userService.save(user);
        redirectAttributes.addFlashAttribute("mess","add successfully");
        return "redirect:/";
    }
}
