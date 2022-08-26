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
public class UserDto{
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

}
