package com.codegym.user_form.util;

import com.codegym.user_form.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.getDayOfBirth().equals("")) {
            errors.rejectValue("dayOfBirth", "age.valid", "must not be blank");
        } else {
            LocalDate dateOfBirth = null;
            try {
                dateOfBirth = LocalDate.parse(userDto.getDayOfBirth());
            } catch (Exception e) {
                errors.rejectValue("dayOfBirth", "age.valid", "Please input right format");
            }

            int age = dateOfBirth.until(LocalDate.now()).getYears();

            if (age < 18) {
                errors.rejectValue("dayOfBirth", "age.valid", "Age must be greater than or equal to 18");
            }
        }
    }
}
