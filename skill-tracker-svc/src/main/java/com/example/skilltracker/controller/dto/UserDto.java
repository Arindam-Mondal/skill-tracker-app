package com.example.skilltracker.controller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String name;
    private String email;
    private String mobile;
    Set<UserRoleDto> userRoles;
}
