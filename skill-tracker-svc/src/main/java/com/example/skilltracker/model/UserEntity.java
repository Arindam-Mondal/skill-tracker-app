package com.example.skilltracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="st_user")
public class UserEntity {
    @Id
    private long id;
    private String name;
    private String email;
    private Boolean isAdmin;
    private String password;
//    @ManyToMany
//    @JoinTable(
//        name = "st_user_skill",
//        joinColumns = @JoinColumn(name = "id"),
//        inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<UserSkillEntity> userSkills;
}
