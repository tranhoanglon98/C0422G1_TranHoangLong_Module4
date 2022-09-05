package com.codegym.phone_web_service.controller;

import com.codegym.phone_web_service.model.Phone;
import com.codegym.phone_web_service.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @GetMapping("")
    public ResponseEntity<Page<Phone>> goPhonePage(){

    }
}
