package com.email.repository.impl;

import com.email.model.EmailBox;
import com.email.repository.IEmailBoxSettingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxSettingRepository implements IEmailBoxSettingRepository {
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();
    private EmailBox emailBox;

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        languageList.add("Korean");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(75);
        pageSizeList.add(100);
    }

    @Override
    public List<String> languageList() {
        return languageList;
    }

    @Override
    public List<Integer> pageSizeList() {
        return pageSizeList;
    }

    @Override
    public void updateSetting(EmailBox emailBox) {
        this.emailBox = emailBox;
    }

}
