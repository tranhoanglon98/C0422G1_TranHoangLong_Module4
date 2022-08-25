package com.codegym.user_form.service.impl;

import com.codegym.user_form.model.User;
import com.codegym.user_form.repository.IUserRepository;
import com.codegym.user_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
