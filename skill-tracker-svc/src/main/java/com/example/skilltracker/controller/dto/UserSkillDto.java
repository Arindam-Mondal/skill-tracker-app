package com.example.skilltracker.controller.dto;

import lombok.Data;

@Data
public class UserSkillDto {
    private Long id;
    private int rating;
    private SkillDto skill;
}
