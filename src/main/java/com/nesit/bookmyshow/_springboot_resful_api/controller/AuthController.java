package com.nesit.bookmyshow._springboot_resful_api.controller;
import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BookUser> register(@RequestBody BookUser bookUser) {
        BookUser registeredUser = userService.registerAsCustomer(bookUser);
        if (registeredUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<BookUser> login(@RequestBody BookUser bookUser) {
        BookUser loggedInUser = userService.loginAsCustomer(bookUser);
        if (loggedInUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookUser>> getAllUsers() {
        List<BookUser> bookUsers = userService.getAllUsers();
        if (bookUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookUsers, HttpStatus.OK);
    }
}
