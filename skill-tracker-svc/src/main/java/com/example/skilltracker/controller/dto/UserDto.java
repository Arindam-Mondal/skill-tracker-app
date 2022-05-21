package com.example.skilltracker.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private Boolean isAdmin;
}
