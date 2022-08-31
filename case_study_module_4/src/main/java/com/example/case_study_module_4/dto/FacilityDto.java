package com.example.case_study_module_4.dto;

import com.example.case_study_module_4.model.facility.FacilityType;
import com.example.case_study_module_4.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto implements Validator {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private Integer area;

    @NotBlank
    private Double cost;

    @NotBlank
    private Integer maxPeople;

    @NotBlank
    private String standardRoom;

    @NotBlank
    private String otherConvenient;

    @NotBlank
    private Double poolArea;

    @NotBlank
    private Integer floors;

    @NotBlank
    private String facilityFree;

    private RentType rentType;
    private FacilityType facilityType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        FacilityDto facilityDto = (FacilityDto) target;

        if (!(facilityDto.name == null || facilityDto.name.trim().equals(""))) {
            if (facilityDto.name.matches("^([1-9A-Z][\\w]*)+( [1-9A-Z][\\w]*)*$")) {
                errors.rejectValue("name", "name.err", "please input right format(ex: Villa123)");
            }
        }
    }
}
