package com.example.skilltracker.util;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.search.SearchCriteria;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SkilltrackerUtil {

    public static UserEntity convertUserDtoToEntity(UserDto userDto){
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userDto.getUserSkills().stream().forEach(userSkillDto -> {

        });

        return userEntity;
    }
}
