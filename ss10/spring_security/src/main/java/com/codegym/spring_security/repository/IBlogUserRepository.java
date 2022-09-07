package com.codegym.spring_security.repository;

import com.codegym.spring_security.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogUserRepository extends JpaRepository<BlogUser,Long> {

    BlogUser findByUserName(String userName);
}
