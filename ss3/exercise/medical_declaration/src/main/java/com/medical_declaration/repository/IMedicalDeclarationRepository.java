package com.medical_declaration.repository;

import com.medical_declaration.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {

    List<String> getDays();

    List<String> getMonths();

    List<String> getYears();

    List<String> getGender();

    List<String> getNationalities();

    List<String> getTransports();

    void add(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> listOfMedicalDeclaration();

    void update(int id,MedicalDeclaration medicalDeclaration);

    MedicalDeclaration findById(int id);
}
