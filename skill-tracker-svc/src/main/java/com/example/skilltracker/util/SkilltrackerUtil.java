package com.example.skilltracker.util;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import org.modelmapper.ModelMapper;

public class SkilltrackerUtil {

    public static UserEntity convertUserDtoToEntity(UserDto userDto){
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userDto.getUserSkills().stream().forEach(userSkillDto -> {

        });

        return userEntity;
    }
}
