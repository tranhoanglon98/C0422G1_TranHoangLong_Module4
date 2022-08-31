package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.dto.FacilityDto;
import com.example.case_study_module_4.model.facility.Facility;
import com.example.case_study_module_4.service.facility.IFacilityService;
import com.example.case_study_module_4.service.facility.IFacilityTypeService;
import com.example.case_study_module_4.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class  FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        this.facilityService.delete(id);
        return "redirect:/facility";
    }

    @GetMapping("/add")
    public String goFacilityAddPage(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",this.facilityTypeService.findAll());
        model.addAttribute("rentTypeList",this.rentTypeService.findAll());
        return "/facility/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FacilityDto facilityDto,
                       Model model, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.facilityService.save(facility);
        if (facility.getId()==null){
            redirectAttributes.addFlashAttribute("mess","Add facility successfully!");
            return "redirect:/facility/add";
        }
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String goFacilityEditPage(@RequestParam Integer id, Model model){
        FacilityDto facilityDto = new FacilityDto();
        Facility facility = this.facilityService.findById(id);
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("facilityTypeList",this.facilityTypeService.findAll());
        model.addAttribute("rentTypeList",this.rentTypeService.findAll());
        return "/facility/edit";
    }
}
