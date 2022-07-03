package com.example.skilltracker.controller.dto;

import lombok.Data;

@Data
public class SkillDto {
    private long id;
    private String name;
    private boolean isTechnical;
}
