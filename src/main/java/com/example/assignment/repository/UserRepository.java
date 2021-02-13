package com.example.assignment.repository;

import com.example.assignment.repository.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
