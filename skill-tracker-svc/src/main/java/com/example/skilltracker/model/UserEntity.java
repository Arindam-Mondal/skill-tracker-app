package com.example.skilltracker.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Builder
@Entity
@Table(name="st_user")
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is mandatory")
    @Size(min=5,max=30,message = "Name should have a length between 5 and 30")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String password;
    private String mobile;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRoleEntity> userRoles;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserSkillEntity> userSkills;

}
