package com.example.skilltracker.service.impl;

import com.example.skilltracker.model.SkillEntity;
import com.example.skilltracker.repository.SkillRepository;
import com.example.skilltracker.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<SkillEntity> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Map<Long, SkillEntity> getAllSkillAsMap() {
        List<SkillEntity> skillEntityList = getAllSkills();
        Map<Long,SkillEntity> skillEntityMap = new HashMap<>();
        skillEntityList.stream().forEach(skillEntity -> {
            skillEntityMap.put(skillEntity.getId(),skillEntity);
        });

        return skillEntityMap;
    }
}
