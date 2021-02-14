package com.example.assignment.service;

import com.example.assignment.repository.RoleRepository;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.repository.dto.Role;
import com.example.assignment.repository.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void registerUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setDeleted(false);
        Role role = new Role();
        role.setDescription("Student");
        roleRepository.save(role);
        user.setRole(role);
        System.out.println(user);
        userRepository.save(user);
    }
}
