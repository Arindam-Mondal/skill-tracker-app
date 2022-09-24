package com.example.skilltracker.dto;

import lombok.Data;

@Data
public class UserSkillDto {
    private Long id;
    private int rating;
    private Long skillId;
}
