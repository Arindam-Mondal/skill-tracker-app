package com.example.skilltracker.controller.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private Boolean isAdmin;
}
