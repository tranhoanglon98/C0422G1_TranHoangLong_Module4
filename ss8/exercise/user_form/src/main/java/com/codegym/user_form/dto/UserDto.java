package com.codegym.user_form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {
    private int id;

    @Size(min = 5, max = 45, message = "First name can only be from 5 to 45 characters!!!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Please input right format!!!")
    @NotBlank
    private String firstName;

    @Size(min = 5, max = 45, message = "First name can only be from 5 to 45 characters!!!")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Please input right format!!!")
    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^(\\+[0-9]{2}|0)[0-9]{9}$", message = "Please input right format")
    private String phoneNumber;

    private String dayOfBirth;

    @Email
    @NotBlank
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.dayOfBirth.equals("")) {
            errors.rejectValue("dayOfBirth", "age.valid", "must not be blank");
        } else {
            LocalDate dateOfBirth = null;
            try {
                dateOfBirth = LocalDate.parse(userDto.dayOfBirth);
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
