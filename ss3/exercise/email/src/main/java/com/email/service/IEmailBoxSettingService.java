package com.email.service;

import com.email.model.EmailBox;

import java.util.List;

public interface IEmailBoxSettingService {

    List<String> languageList();

    List<Integer> pageSizeList();

    void updateSetting(EmailBox emailBox);

}
