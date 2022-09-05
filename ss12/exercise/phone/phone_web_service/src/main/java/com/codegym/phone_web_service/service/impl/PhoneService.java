package com.codegym.phone_web_service.service.impl;

import com.codegym.phone_web_service.model.Phone;
import com.codegym.phone_web_service.repository.IPhoneRepository;
import com.codegym.phone_web_service.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return this.phoneRepository.findAll(pageable);
    }

    @Override
    public void save(Phone phone) {
        this.phoneRepository.save(phone);
    }

    @Override
    public void delete(Integer id) {
        this.phoneRepository.delete(findById(id));
    }

    @Override
    public Phone findById(Integer id) {
        return this.phoneRepository.findById(id).orElseGet(null);
    }
}
