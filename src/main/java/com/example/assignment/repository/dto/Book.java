package com.example.assignment.repository.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    private String isbn;

    private String name;

    private String author;

    private Integer count;

    private Boolean deleted;
}
