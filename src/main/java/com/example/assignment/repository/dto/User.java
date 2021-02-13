package com.example.assignment.repository.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id")
    private String username;

    private String password;

    private String name;

    private String surname;

    private Boolean deleted;

    @OneToOne(optional = false)
    @JoinColumn(name="role_id")
    private Role role;

}
