package com.example.skilltracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="st_user_skill")
public class UserSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private Long skillId;
    private String rating;
}
