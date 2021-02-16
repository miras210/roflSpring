package com.example.assignment.controller;

import com.example.assignment.repository.dto.Role;
import com.example.assignment.repository.dto.User;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String toRegister(Model model) {
        model.addAttribute("user", new User());
        return "addStudent";
    }

    @PostMapping("")
    public String registerStudent(@ModelAttribute("user") User user, Model model) {
        String check = userService.registerUser(user);
        if (check.equals("ok")){
            return "redirect:/";
        }
        if (check.equals("restored")) {
            model.addAttribute("message", "User with this username is restored");
            return "error";
        }
        else if (check.equals("error")){
            model.addAttribute("message", "Such user is already registered");
            return "error";
        }
        return "redirect:/";
    }
}
