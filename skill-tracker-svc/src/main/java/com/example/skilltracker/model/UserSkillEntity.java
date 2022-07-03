package com.example.skilltracker.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="st_user_skill")
public class UserSkillEntity {
    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private Long skillId;
    private String rating;
}
