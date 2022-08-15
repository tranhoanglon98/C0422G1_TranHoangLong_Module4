package com.dictionary.controller;


import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String goDictionary(){
        return "dictionary";
    }

    @GetMapping("/search")
    public String search(@RequestParam String word, Model model){
        String result = iDictionaryService.search(word);
        model.addAttribute("result",result);
        return "dictionary";
    }
}
