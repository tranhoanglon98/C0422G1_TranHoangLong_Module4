package com.email.service.impl;

import com.email.model.EmailBox;
import com.email.repository.IEmailBoxSettingRepository;
import com.email.service.IEmailBoxSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxSettingService implements IEmailBoxSettingService {

    @Autowired
    private IEmailBoxSettingRepository iEmailBoxSettingRepository;

    @Override
    public List<String> languageList() {
        return iEmailBoxSettingRepository.languageList();
    }

    @Override
    public List<Integer> pageSizeList() {
        return iEmailBoxSettingRepository.pageSizeList();
    }

    @Override
    public void updateSetting(EmailBox emailBox) {
        this.iEmailBoxSettingRepository.updateSetting(emailBox);
    }

}
