package com.codegym.phone_web_service.repository;

import com.codegym.phone_web_service.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}
