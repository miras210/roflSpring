package com.example.assignment.repository.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    private Integer role_id;

    private Boolean deleted;

}
