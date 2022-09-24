package com.example.skilltracker.service;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import org.springframework.stereotype.Service;

public interface UserTransformationService {

    public UserEntity userDtoToUserEntity(UserDto userDto);
}
