package com.codegym.user_form.repository;

import com.codegym.user_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
