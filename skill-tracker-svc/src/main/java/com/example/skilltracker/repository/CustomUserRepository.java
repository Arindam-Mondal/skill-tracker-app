package com.example.skilltracker.repository;

import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.search.SearchCriteria;

import java.util.List;

public interface CustomUserRepository {
    public List<UserEntity> getUserByNameAssociateIdAndSkill(List<SearchCriteria> params);
}
