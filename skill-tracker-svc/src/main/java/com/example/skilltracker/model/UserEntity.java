package com.example.skilltracker.model;

import lombok.*;

import javax.persistence.*;

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
}
