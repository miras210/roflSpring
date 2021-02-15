package com.example.assignment.repository;

import com.example.assignment.repository.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findBookByIsbn(String isbn);
}
