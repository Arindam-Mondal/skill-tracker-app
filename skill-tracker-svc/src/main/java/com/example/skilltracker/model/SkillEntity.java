package com.example.skilltracker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="st_skill")
public class SkillEntity {
    @Id
    private long id;
    private String name;
    private Boolean isTechnical;
}
