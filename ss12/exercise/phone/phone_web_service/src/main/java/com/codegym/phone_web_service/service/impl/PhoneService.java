package com.codegym.phone_web_service.service.impl;

import com.codegym.phone_web_service.model.Phone;
import com.codegym.phone_web_service.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService {

    @Autowired


    @Override
    public Page<Phone> findAll() {
        return null;
    }
}
