package com.codegym.spring_security.repository;

import com.codegym.spring_security.model.BlogUser;
import com.codegym.spring_security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByBlogUsers(BlogUser blogUser);
}
