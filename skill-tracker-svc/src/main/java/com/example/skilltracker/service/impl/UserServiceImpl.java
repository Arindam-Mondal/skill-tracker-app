package com.example.skilltracker.service.impl;

import com.example.skilltracker.dto.UserDto;
import com.example.skilltracker.enums.RoleType;
import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.model.UserRoleEntity;
import com.example.skilltracker.repository.CustomUserRepository;
import com.example.skilltracker.repository.SkillRepository;
import com.example.skilltracker.repository.UserRepository;
import com.example.skilltracker.search.SearchCriteria;
import com.example.skilltracker.search.UserSearchQueryCriteriaConsumer;
import com.example.skilltracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserRepository customUserRepository;

    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public UserEntity createUserProfile(UserEntity userEntity,RoleType roleType) {

        Set<UserRoleEntity> userRoleSet = new HashSet<>();
        userEntity.setId(null);
        UserRoleEntity userRoleEntity = UserRoleEntity.builder().user(userEntity).role(roleType).build();
        userRoleSet.add(userRoleEntity);
        userEntity.setUserRoles(userRoleSet);
        return userRepository.save(userEntity);

    }

    @Override
    public UserEntity updateUserProfile(UserEntity userEntity) {
        //User Should be able to update only the expertiseLevel
        //Prepare the userskill entity
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User Not found with id " + id));
    }

    @Override
    public List<UserEntity> getUserByNameAssociateIdAndSkill(String name,String associateId,String skill) {
        List<SearchCriteria> params = convertParamsToCriteria(name,associateId,skill);
        return customUserRepository.getUserByNameAssociateIdAndSkill(params);
    }

    private List<SearchCriteria> convertParamsToCriteria(String name,String associateId,String Skill){
        List<SearchCriteria> parameters = new ArrayList<SearchCriteria>();
        if(name != null && name != "" ){
            parameters.add(new SearchCriteria("name",":",name));
        }
        if(associateId != null && associateId != "" ){
            parameters.add(new SearchCriteria("associateId",":",associateId));
        }
        return parameters;
    }
}
