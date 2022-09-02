package com.example.skilltracker.auth.service.impl;

import com.example.skilltracker.auth.model.UserEntity;
import com.example.skilltracker.auth.service.UserService;
import com.example.skilltracker.auth.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userInfo = userService.getUserInfoByEmail(email);
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        UserDetails userDetails = User.withUsername("user4")
            .authorities("ADMIN", "STAFF_MEMBER")
            .passwordEncoder(passwordEncoder::encode)
            .password("1234")
            .build();

        return userDetails;
//        return new User(userInfo.getEmail(), userInfo.getPassword(), Arrays.asList(authority)).en;
    }
}
