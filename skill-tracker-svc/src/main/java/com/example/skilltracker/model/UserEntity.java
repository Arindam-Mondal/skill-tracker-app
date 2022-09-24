package com.example.skilltracker.model;

import com.example.skilltracker.validation.constrains.AssociateId;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="st_user")
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Size(min=5,max=30,message = "Name should have a length between 5 and 30")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message="Should be a valid email")
    private String email;
    @NotBlank(message = "Associate Id is mandatory")
    @Size(min=5,max=30,message = "Associate Id should have a length between 5 and 30")
    @AssociateId(message="Associate Id should start with CTS")
    private String associateId;
    private String password;
    @NotBlank(message="Mobile is mandatory")
    @Size(min=10,max=10,message = "Mobile Number should be of length 10")
    private String mobile;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRoleEntity> userRoles;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserSkillEntity> userSkills;

}
