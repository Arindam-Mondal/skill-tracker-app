package com.example.skilltracker.auth.service.impl;

import com.example.skilltracker.auth.model.UserEntity;
import com.example.skilltracker.auth.repository.UserRepository;
import com.example.skilltracker.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserInfoByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
