package com.example.assignment.repository;

import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.Event;
import com.example.assignment.repository.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByUser(User u);
    List<Event> findEventsByBook_IsbnAndUser_Username(String isbn, String id);
}
