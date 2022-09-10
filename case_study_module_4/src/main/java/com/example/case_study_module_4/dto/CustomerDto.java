package com.example.case_study_module_4.dto;

import com.example.case_study_module_4.model.customer.CustomerType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CustomerDto implements Validator {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String dayOfBirth;

    @NotNull
    private Boolean gender;

    @NotBlank
    private String idCard;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    @NotNull
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!(customerDto.dayOfBirth == null || customerDto.dayOfBirth.equals(""))) {
            try {
                LocalDate.parse(customerDto.dayOfBirth);
            } catch (Exception e) {
                errors.rejectValue("dayOfBirth", "day.err", "please input right format");
            }
        }

        if (!(customerDto.name == null || customerDto.name.trim().equals(""))) {
            if (!customerDto.name.matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+" +
                    "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$")) {
                errors.rejectValue("name", "name.err", "Please input right format!!! ex: Trần Hoàng Long");
            }
        }

        if (!(customerDto.idCard == null || customerDto.idCard.trim().equals(""))) {
            if (!customerDto.idCard.matches("^[0-9]{9}|[0-9]{12}$")) {
                errors.rejectValue("idCard", "idCard.err", "Please input right format!!! (9 or 12 numbers)");
            }
        }

        if (!(customerDto.phoneNumber == null || customerDto.phoneNumber.trim().equals(""))) {
            if (!customerDto.phoneNumber.matches("^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$")) {
                errors.rejectValue("phoneNumber", "phone.err", "wrong format(090/091/(+84)+90/(+84)+91 and 7 nums)");
            }
        }
    }

}
