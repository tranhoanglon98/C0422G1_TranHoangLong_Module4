package com.codegym.user_form.service;

import com.codegym.user_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> findAll(Pageable pageable);

    void save(User user);
}
