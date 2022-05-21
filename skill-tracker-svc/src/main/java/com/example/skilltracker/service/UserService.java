package com.example.skilltracker.service;

import com.example.skilltracker.controller.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<UserEntity> getAllUsers();
}
