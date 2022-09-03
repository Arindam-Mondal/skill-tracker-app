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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private SkillEntity skill;
    private String rating;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
}
