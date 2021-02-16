package com.example.assignment.controller;

import com.example.assignment.repository.EventRepository;
import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.User;
import com.example.assignment.service.BookService;
import com.example.assignment.service.EventService;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    private EventService eventService;
    private BookService bookService;
    private UserService userService;

    @Autowired
    public EventController(EventService eventService, BookService bookService, UserService userService) {
        this.eventService = eventService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable(value = "id") String id, Model model) {
        model.addAttribute("books", bookService.showBooks());
        return "borrowBook";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable(value = "id") String id, @RequestParam("isbn")List<String> books) {
        User u = userService.getUserById(id);
        ArrayList<Book> b = bookService.getBooksByIsbn(books);
        eventService.borrowBooks(u, b);
        return "redirect:/";
    }
    @GetMapping("/{id}/return/{isbn}")
    public String returnBook(@PathVariable(value = "isbn") String isbn, @PathVariable(value = "id") String id){
        Book b = bookService.findBookbyIsbn(isbn);
        User u = userService.getUserById(id);
        eventService.returnBook(u, b);
        return "redirect:/";
    }
    @GetMapping("/events")
    public String toEvents(Model model){
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }
}
