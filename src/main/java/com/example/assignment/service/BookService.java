package com.example.assignment.service;

import com.example.assignment.repository.BookRepository;
import com.example.assignment.repository.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerBook(Book book){
        book.setDeleted(false);
        bookRepository.save(book);
    }
}
