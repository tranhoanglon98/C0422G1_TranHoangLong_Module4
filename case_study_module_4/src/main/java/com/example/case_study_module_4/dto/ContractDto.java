package com.example.case_study_module_4.dto;

import java.time.LocalDate;

public interface ContractDto {

    Integer getId();

    LocalDate getStartDay();

    LocalDate getEndDay();

    Double getDeposit();

    String getCustomerName();

    String getFacilityName();

    Double getTotal();
}
