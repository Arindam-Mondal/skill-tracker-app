package com.example.skilltracker.service;


import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.enums.RoleType;
import com.example.skilltracker.model.UserEntity;

import java.util.List;


public interface UserService {
    public List<UserEntity> getAllUsers();
    public UserEntity createUserProfile(UserEntity userEntity, RoleType roleType);
    public UserEntity updateUserProfile(UserEntity userEntity);
    public UserEntity getUserById(long id);
}
