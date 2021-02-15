package com.example.assignment.controller;

import com.example.assignment.repository.BookRepository;
import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.User;
import com.example.assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBook")
    public String bookAddPage(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.registerBook(book);
        return "redirect:/";
    }
}
