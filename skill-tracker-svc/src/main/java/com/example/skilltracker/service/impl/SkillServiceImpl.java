package com.example.skilltracker.service.impl;

import com.example.skilltracker.model.SkillEntity;
import com.example.skilltracker.repository.SkillRepository;
import com.example.skilltracker.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<SkillEntity> getAllSkills() {
        return skillRepository.findAll();
    }
}
