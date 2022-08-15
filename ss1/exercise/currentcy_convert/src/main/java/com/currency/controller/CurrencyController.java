package com.currency.controller;

import com.currency.service.ICurrencyService;
import com.currency.service.impl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.Map;

@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/currency")
    public String currency(@RequestParam String amount, @RequestParam String from, Model model) {
        Map<String, String> errMap = iCurrencyService.validate(amount, from);
        model.addAttribute("amount",amount);
        model.addAttribute("to",(from.equals("USD")?"VND":"USD"));
        model.addAttribute("from", from);
        if (errMap.isEmpty()){
            String pattern = ".######";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            double result = iCurrencyService.convertCurrency(amount, from);
            model.addAttribute("result", decimalFormat.format(result));
        }else {
            model.addAttribute("errMap",errMap);
        }

        return "home";
    }
}
