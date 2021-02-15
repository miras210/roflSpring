package com.example.assignment.service;

import com.example.assignment.repository.RoleRepository;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.Role;
import com.example.assignment.repository.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        userRepository.save(user);
    }
    public Iterable<User> showUsers(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public ArrayList<User> getId(String id){
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        return res;
    }
    public void updateUser(String id, User user){
        User updatedUser = userRepository.findById(id).orElseThrow();
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setSurname(user.getSurname());
        userRepository.save(updatedUser);
    }
    public void deleteUser(String id){
        User deletingUser = userRepository.findById(id).orElseThrow();
        deletingUser.setDeleted(true);
        userRepository.save(deletingUser);
    }

}
