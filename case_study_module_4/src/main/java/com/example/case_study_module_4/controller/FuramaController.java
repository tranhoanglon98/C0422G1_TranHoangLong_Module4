package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.model.contract.Contract;
import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.model.facility.Facility;
import com.example.case_study_module_4.service.contract.IAttachFacilityService;
import com.example.case_study_module_4.service.contract.IContractDetailService;
import com.example.case_study_module_4.service.contract.IContractService;
import com.example.case_study_module_4.service.customer.ICustomerService;
import com.example.case_study_module_4.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FuramaController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/")
    public String goHomePage() {
        return "home";
    }

    @GetMapping("/customer")
    public String goCustomerPage(Model model,
                                 @RequestParam(required = false, defaultValue = "") String searchValue,
                                 @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerPage = this.customerService.findByNameOrId(searchValue, pageable);
        model.addAttribute("customerList", customerPage);
        model.addAttribute("searchValue", searchValue);

        if (customerPage.getTotalPages() > 0) {
            int[] pageNumber = new int[customerPage.getTotalPages()];
            model.addAttribute("pageNumber", pageNumber);
        }
        if (customerPage.isEmpty()) {
            model.addAttribute("result", "Not Found");
        }
        return "customer/list";
    }

    @GetMapping("/facility")
    public String goFacilityPage(@PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "") String searchValue,
                                 Model model) {

        Page<Facility> facilityPage = this.facilityService.findByNameOrId(searchValue, pageable);
        model.addAttribute("facilityList", facilityPage);

        if (facilityPage.getTotalPages() > 0) {
            int[] pageNumber = new int[facilityPage.getTotalPages()];
            model.addAttribute("pageNumber", pageNumber);
        }
        if (facilityPage.isEmpty()) {
            model.addAttribute("result", "Not Found");
        }
        return "facility/list";
    }

    @GetMapping("/employee")
    public String goEmployeePage() {
        return "employee/list";
    }

    @GetMapping("/contract")
    public String goContractPage(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Contract> contractPage = this.contractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        if (contractPage.getTotalPages() > 0) {
            int[] pageNumber = new int[contractPage.getTotalPages()];
            model.addAttribute("pageNumber", pageNumber);
        }
        if (contractPage.isEmpty()) {
            model.addAttribute("result", "Not Found");
        }
        return "contract/list";
    }
}
