package com.example.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/addBook")
    public String bookAddPage(){
        return "addBook";
    }
    @PostMapping("/add")
    public void addBook(){
        System.out.println("Added book");
    }
}
