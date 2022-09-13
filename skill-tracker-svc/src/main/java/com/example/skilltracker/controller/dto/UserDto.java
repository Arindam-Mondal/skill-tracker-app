package com.example.skilltracker.controller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String associateId;
    Set<UserRoleDto> userRoles;
    Set<UserSkillDto> userSkills;
}
