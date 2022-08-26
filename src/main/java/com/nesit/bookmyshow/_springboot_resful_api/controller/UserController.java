package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.User;
import com.nesit.bookmyshow._springboot_resful_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> viewUser() {
        return userService.viewUser();
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id) {
        userService.updateUser(1);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(2);
    }
}
