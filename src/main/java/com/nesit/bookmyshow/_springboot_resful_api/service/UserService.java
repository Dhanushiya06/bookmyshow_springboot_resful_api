package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(BookUser bookUser) {
        userRepository.save(bookUser);
    }

    public List<BookUser> viewUser() {
        return null;
    }

    public void updateUser(BookUser bookUser) {
        userRepository.save(bookUser);

    }

    public void deleteUser(int id) {
        BookUser bookUser = userRepository.findById(id).get();
        userRepository.delete(bookUser);

    }
}
