package com.example.skilltracker.service.impl;

import com.example.skilltracker.controller.dto.UserDto;
import com.example.skilltracker.enums.RoleType;
import com.example.skilltracker.model.SkillEntity;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.model.UserRoleEntity;
import com.example.skilltracker.model.UserSkillEntity;
import com.example.skilltracker.repository.SkillRepository;
import com.example.skilltracker.repository.UserRepository;
import com.example.skilltracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUserProfile(UserEntity userEntity) {
        //while creating the user profile for the first time we will set all the skills default to Zero.
        //User needs to update the skill once profile is created.
        List<SkillEntity> skillList = skillRepository.findAll();
        Set<UserSkillEntity> userSkillSet = new HashSet<>();
        Set<UserRoleEntity> userRoleSet = new HashSet<>();
        skillList.stream().forEach(skill -> {
            UserSkillEntity userSkillEntity = UserSkillEntity.builder().skill(skill).user(userEntity).rating(1).build();
            userSkillSet.add(userSkillEntity);
        });

        UserRoleEntity userRoleEntity = UserRoleEntity.builder().user(userEntity).role(RoleType.ENGINEER).build();
        userRoleSet.add(userRoleEntity);

        userEntity.setUserRoles(userRoleSet);
        userEntity.setUserSkills(userSkillSet);

        return userRepository.save(userEntity);

    }

    @Override
    public UserEntity updateUserProfile(UserEntity userEntity) {
        //User Should be able to update only the expertiseLevel
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User Not found with id " + id));
    }
}
