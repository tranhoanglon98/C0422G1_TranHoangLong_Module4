package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.dto.FacilityDto;
import com.example.case_study_module_4.model.facility.Facility;
import com.example.case_study_module_4.service.facility.IFacilityService;
import com.example.case_study_module_4.service.facility.IFacilityTypeService;
import com.example.case_study_module_4.service.facility.IRentTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/facility")
public class  FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.facilityService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Delete successfully");
        return "redirect:/facility";
    }

    @GetMapping("add")
    public String goFacilityAddPage(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",this.facilityTypeService.findAll());
        model.addAttribute("rentTypeList",this.rentTypeService.findAll());
        return "/facility/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid FacilityDto facilityDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model){
         new FacilityDto().validate(facilityDto,bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",this.facilityTypeService.findAll());
            model.addAttribute("rentTypeList",this.rentTypeService.findAll());
            if (facilityDto.getId() == null){
                model.addAttribute("mess","Add field");
                return "/facility/add";
            }
            model.addAttribute("mess","Edit field");
            return "/facility/edit";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.facilityService.save(facility);
        if (facilityDto.getId() == null){
            redirectAttributes.addFlashAttribute("mess","Add successfully!");
            return "redirect:/facility/add";
        }
        redirectAttributes.addFlashAttribute("mess","Edit successfully!");
        return "redirect:/facility";
    }

    @GetMapping("edit")
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
