package com.example.skilltracker.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Builder
@Entity
@Table(name="st_user_skill")
public class UserSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private SkillEntity skill;
    private int rating;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
}
