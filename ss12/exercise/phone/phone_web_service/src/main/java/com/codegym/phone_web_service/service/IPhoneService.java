package com.codegym.phone_web_service.service;

import com.codegym.phone_web_service.model.Phone;
import org.springframework.data.domain.Page;

public interface IPhoneService {

    Page<Phone> findAll();

}
