package com.example.assignment.repository;

import com.example.assignment.repository.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
