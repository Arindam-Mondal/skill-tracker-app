package com.example.skilltracker.controller.dto;

import lombok.Data;

@Data
public class UserSkillDto {
    private Long skillId;
    private String rating;
    private SkillDto skill;
}
