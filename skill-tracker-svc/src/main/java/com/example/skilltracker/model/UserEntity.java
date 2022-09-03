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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private String mobile;
    @OneToMany(mappedBy = "user")
    private Set<UserRoleEntity> userRoles;
    @OneToMany(mappedBy = "user")
    private Set<UserSkillEntity> userSkills;

}
