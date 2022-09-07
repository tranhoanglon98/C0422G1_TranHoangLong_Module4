package com.codegym.spring_security.service.impl;

import com.codegym.spring_security.model.BlogUser;
import com.codegym.spring_security.model.Role;
import com.codegym.spring_security.repository.IBlogUserRepository;
import com.codegym.spring_security.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IBlogUserRepository blogUserRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BlogUser blogUser = this.blogUserRepository.findByUserName(username);

        if (blogUser == null) {
            throw new UsernameNotFoundException("BỐ mày đéo tìm đc oke, cút");
        }
        List<Role> roleList = this.roleRepository.findByBlogUsers(blogUser);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Role role : roleList){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            grantedAuthorityList.add(grantedAuthority);
        }

        UserDetails userDetails = (UserDetails) new User(blogUser.getUserName(), blogUser.getPassword(),
                grantedAuthorityList);

        return userDetails;
    }
}
