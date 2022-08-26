package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.User;
import com.nesit.bookmyshow._springboot_resful_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> viewUser() {
        return null;
    }

    public void updateUser(int id) {

    }

    public void deleteUser(int id) {

    }
}
