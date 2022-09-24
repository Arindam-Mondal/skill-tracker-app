package com.example.skilltracker.service.impl;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.dto.UserSkillDto;
import com.example.skilltracker.model.SkillEntity;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.model.UserRoleEntity;
import com.example.skilltracker.model.UserSkillEntity;
import com.example.skilltracker.service.SkillService;
import com.example.skilltracker.service.UserTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserTransformationServiceImpl implements UserTransformationService {

    @Autowired
    SkillService skillService;

    @Override
    public UserEntity userDtoToUserEntity(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .associateId(userDto.getAssociateId())
                .mobile(userDto.getMobile())
                .build();

        //create the Skills
        //getting all the skills from the db
        //Need to check how can we cache this data and not do a db call every time
        //Since Skill is static
        Map<Long,SkillEntity> skillEntityMap = skillService.getAllSkillAsMap();
        Set<UserSkillEntity> userSkillEntitySet = new HashSet<>();
        userDto.getUserSkills().stream().forEach(userSkillDto -> {
            //Create the Skill
            SkillEntity skillEntity = skillEntityMap.get(userSkillDto.getSkillId());
            UserSkillEntity userSkillEntity = UserSkillEntity
                    .builder()
                    .id(userSkillDto.getId())
                    .rating(userSkillDto.getRating())
                    .user(userEntity)
                    .skill(skillEntity)
                    .build();
            userSkillEntitySet.add(userSkillEntity);
        });

        userEntity.setUserSkills(userSkillEntitySet);
        return userEntity;
    }
}
