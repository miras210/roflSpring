package com.example.assignment.service;

import com.example.assignment.repository.BookRepository;
import com.example.assignment.repository.EventRepository;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.repository.dto.Book;
import com.example.assignment.repository.dto.Event;
import com.example.assignment.repository.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void borrowBooks(User u, ArrayList<Book> books) {
        for (Book b : books) {
            Event e = new Event();
            e.setBook(b);
            e.setUser(u);
            e.setEvent_name("Borrow");
            e.setDate(new Date());
            b.setCount(b.getCount()-1);
            bookRepository.save(b);
            eventRepository.save(e);
        }
    }

    public ArrayList<Book> getBorrowedBooks(String id) {
        User u = userRepository.findById(id).get();
        ArrayList<Event> borrows = (ArrayList<Event>) eventRepository.findAllByUser(u);
        ArrayList<Book> books = new ArrayList<>();
        for (Event e : borrows) {
            if (e.getEvent_name().equals("Borrow")) {
                books.add(e.getBook());
            }
        }
        return books;
    }
}
