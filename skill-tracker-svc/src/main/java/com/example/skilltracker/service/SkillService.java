package com.example.skilltracker.service;

import com.example.skilltracker.model.SkillEntity;

import java.util.List;
import java.util.Map;

public interface SkillService {
    public List<SkillEntity> getAllSkills();
    public Map<Long,SkillEntity> getAllSkillAsMap();
}
