package com.validateEmail.service.impl;

import com.validateEmail.service.IEmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Override
    public boolean validateEmail(String email) {
        String emailRegex = "\\w+@\\w+\\.\\w+";
        if (email.matches(emailRegex)){
            return true;
        }
        return false;
    }
}
