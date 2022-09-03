package com.example.skilltracker.service.impl;

import com.example.skilltracker.controller.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.repository.UserRepository;
import com.example.skilltracker.service.UserService;
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
    public UserEntity createUserProfile(UserEntity userEntity) { return userRepository.save(userEntity);}
}
