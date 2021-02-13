package com.example.assignment.repository;

import com.example.assignment.repository.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
