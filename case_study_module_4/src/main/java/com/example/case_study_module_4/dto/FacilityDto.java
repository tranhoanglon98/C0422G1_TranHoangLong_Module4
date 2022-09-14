package com.example.case_study_module_4.dto;

import com.example.case_study_module_4.model.facility.FacilityType;
import com.example.case_study_module_4.model.facility.RentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FacilityDto implements Validator {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String area;

    @NotBlank
    private String cost;

    @NotBlank
    private String maxPeople;

    @NotBlank
    private String standardRoom;

    private String otherConvenient;

    private String poolArea;

    private String floors;

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

        if (!facilityDto.name.trim().equals("")) {
            if (!(facilityDto.name.matches("^([0-9A-Z][\\w]*)+( [0-9A-Z][\\w]*)*$"))) {
                errors.rejectValue("name", "name.err", "please input right format(ex: Villa123)");
            }
        }


        if (!facilityDto.area.trim().equals("")) {
            try {
                int area = Integer.parseInt(facilityDto.area);
                if (area < 0) {
                    errors.rejectValue("area", "area.err", "Area cannot be negative");
                }
            } catch (Exception e) {
                errors.rejectValue("area", "area.err", "please input right format(Integer number)");
            }
        }


        if (! facilityDto.cost.trim().equals("")) {
            try {
                double area = Double.parseDouble(facilityDto.cost);
                if (area < 0) {
                    errors.rejectValue("cost", "cost.err", "Cost cannot be negative");
                }
            } catch (Exception e) {
                errors.rejectValue("cost", "cost.err", "please input right format (Double number)");
            }
        }


        if (!facilityDto.maxPeople.trim().equals("")) {
            try {
                int area = Integer.parseInt(facilityDto.maxPeople);
                if (area < 0) {
                    errors.rejectValue("maxPeople", "maxPeople.err", "maxPeople cannot be negative");
                }
            } catch (Exception e) {
                errors.rejectValue("maxPeople", "maxPeople.err", "please input right format(Integer number)");
            }
        }

        if (!facilityDto.poolArea.trim().equals("")) {
            try {
                double area = Double.parseDouble(facilityDto.poolArea);
                if (area < 0) {
                    errors.rejectValue("poolArea", "poolArea.err", "poolArea cannot be negative");
                }
            } catch (Exception e) {
                errors.rejectValue("poolArea", "poolArea.err", "please input right format (Double number)");
            }
        } else {
            if (facilityDto.facilityType.getId() == 1) {
                errors.rejectValue("poolArea", "poolArea.err", "must not be blank");
            }

            if (! facilityDto.floors.trim().equals("")) {
                try {
                    int area = Integer.parseInt(facilityDto.floors);
                    if (area < 0) {
                        errors.rejectValue("floors", "floors.err", "floors cannot be negative");
                    }
                } catch (Exception e) {
                    errors.rejectValue("floors", "floors.err", "please input right format(Integer number)");
                }
            } else {
                if (facilityDto.facilityType.getId() != 3) {
                    errors.rejectValue("floors", "floors.err", "must not be blank");
                }
            }

            if (facilityDto.facilityType.getId() != 3) {
                if (facilityDto.otherConvenient == null || facilityDto.otherConvenient.trim().equals("")) {
                    errors.rejectValue("otherConvenient", "otherConvenient.err", "must not be blank");
                }
            }
        }
    }
}
