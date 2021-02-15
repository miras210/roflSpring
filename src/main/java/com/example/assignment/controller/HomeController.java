package com.example.assignment.controller;

import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.User;
import com.example.assignment.service.BookService;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    private BookService bookService;
    private UserService userService;

    @Autowired
    public HomeController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }


    @GetMapping()
    public String toHome(Model model) {
        model.addAttribute("books", bookService.showBooks());
        model.addAttribute("users", userService.showUsers());
        return "index";
    }

    @GetMapping("/user/{id}")
    public String toStudent(@PathVariable(value = "id") String id, Model model){
        model.addAttribute("user", userService.getId(id));
        return "profile";
    }

    @GetMapping("/user/{id}/edit")
    public String updateBookPage(@PathVariable(value = "id") String id, Model model){
        model.addAttribute("user", new User());
        return "updateStudent";
    }

    @PostMapping("/user/{id}/edit")
    public String updateStudent(@ModelAttribute("user") User user, @PathVariable(value = "id") String id){
        userService.updateUser(id, user);
        return "redirect:/";
    }
}
