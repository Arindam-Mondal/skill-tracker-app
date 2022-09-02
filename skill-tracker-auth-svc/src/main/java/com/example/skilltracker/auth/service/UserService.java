package com.example.skilltracker.auth.service;



import com.example.skilltracker.auth.model.UserEntity;

import java.util.List;


public interface UserService {
    public List<UserEntity> getAllUsers();
    public UserEntity getUserInfoByEmail(String email);
}
