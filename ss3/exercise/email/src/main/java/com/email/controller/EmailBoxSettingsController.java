package com.email.controller;

import com.email.model.EmailBox;
import com.email.service.IEmailBoxSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailBoxSettingsController {

    @Autowired
    private IEmailBoxSettingService iEmailBoxSettingService;

    @GetMapping("/")
    public String goSetting(Model model) {
        model.addAttribute("languageList", this.iEmailBoxSettingService.languageList());
        model.addAttribute("pageSizeList", this.iEmailBoxSettingService.pageSizeList());
        model.addAttribute("emailBox", new EmailBox());
        return "email_box_settings_update";
    }

    @PostMapping("/save")
    public String updateSetting(@ModelAttribute EmailBox emailBox, Model model) {
        this.iEmailBoxSettingService.updateSetting(emailBox);
        model.addAttribute("emailBox", emailBox);
        return "email_box_detail";
    }

}
