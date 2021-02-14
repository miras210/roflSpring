package com.example.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class studentController {

    @GetMapping("/addStudent")
    public String studentAddPage(){
        return "addStudent";
    }
    @PostMapping("/add")
    public void addStudent(){
        System.out.println("student adding");
    }
}
