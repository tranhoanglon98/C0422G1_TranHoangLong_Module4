package com.example.case_study_module_4.dto;

import com.example.case_study_module_4.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto  implements Validator {

    private Integer id;

    @NotBlank
    @Pattern(regexp = "^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+" +
            "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)*$",
            message = "Please input right format!!! ex: Trần Hoàng Long")
    private String name;

    private String dayOfBirth;

    private Boolean gender;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$",
            message = "Please input right format!!! (9 or 12 numbers)")
    private String idCard;

    @NotBlank
    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$",
            message = "Please input right format!!!(090/091/(+84)+90/(+84)+91 and 7 numbers)")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (customerDto.dayOfBirth == null || customerDto.dayOfBirth.equals("")){
            errors.rejectValue("dayOfBirth","day.err","must not be blank");
        }else {
            try {
                LocalDate.parse(customerDto.dayOfBirth);
            }catch (Exception e){
                errors.rejectValue("dayOfBirth","day.err","please input right format");
            }
        }
    }
}
