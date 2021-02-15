package com.example.assignment.service;

import com.example.assignment.repository.BookRepository;
import com.example.assignment.repository.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public Iterable<Book> showBooks(){
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }
    public ArrayList<Book> getIsbn(String isbn){
        Optional<Book> book = bookRepository.findById(isbn);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        return res;
    }

    public ArrayList<Book> getBooksByIsbn(List<String> isbn) {
        return (ArrayList<Book>) bookRepository.findAllById(isbn);
    }

    public void updateBook(String isbn, Book book){
        Book updatedBook = bookRepository.findById(isbn).orElseThrow();
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setCount(book.getCount());
        bookRepository.save(updatedBook);
    }
}
