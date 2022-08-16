package com.time.controller;


import com.time.service.ILocalTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TimeController {

    @Autowired
    private ILocalTimeService iLocalTimeService;

    @GetMapping("/")
    public String goLocalTime(){
        return "localTime";
    }


    @GetMapping("/localTime")
    public String localTime(@RequestParam String city, Model model){
        Date localDate = iLocalTimeService.getLocalTime(city);
        model.addAttribute("localDate",localDate);
        model.addAttribute("city",city);
        return "localTime";
    }
}
