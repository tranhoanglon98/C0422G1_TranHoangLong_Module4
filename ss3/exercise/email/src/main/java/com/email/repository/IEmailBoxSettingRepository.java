package com.email.repository;

import com.email.model.EmailBox;

import java.util.List;

public interface IEmailBoxSettingRepository {

    List<String> languageList();

    List<Integer> pageSizeList();

    void updateSetting(EmailBox emailBox);

}
