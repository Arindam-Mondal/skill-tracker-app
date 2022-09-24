package com.example.skilltracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SkillDto {
    private long id;
    private String name;
    @JsonProperty("isTechnical")
    private Boolean isTechnical;
}
