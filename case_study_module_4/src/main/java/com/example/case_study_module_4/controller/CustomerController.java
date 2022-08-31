package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.dto.CustomerDto;
import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.service.customer.ICustomerService;
import com.example.case_study_module_4.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/add")
    public String goCustomerAddPage(Model model) {
        model.addAttribute("customerTypeList", this.customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid CustomerDto customerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", this.customerTypeService.findAll());
            if (customerDto.getId() == null) {
                return "/customer/add";
            }
            return "/customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (customer.getId() == null) {
            this.customerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "add " + customer.getName() + " successfully!");
            return "redirect:/customer/add";
        }

        this.customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer customerCode) {
        this.customerService.delete(customerCode);
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String goCustomerUpdatePage(@RequestParam Integer id, Model model) {
        model.addAttribute("customerTypeList", this.customerTypeService.findAll());
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }
}
