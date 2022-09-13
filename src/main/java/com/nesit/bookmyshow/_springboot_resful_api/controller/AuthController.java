package com.nesit.bookmyshow._springboot_resful_api.controller;


import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.response.APIResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.AuthResponse;
import com.nesit.bookmyshow._springboot_resful_api.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private BookUserService bookUserService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody BookUser bookUser) {
        BookUser registeredUser = bookUserService.registerAsCustomer(bookUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody BookUser bookUser) {
        AuthResponse loggedInUser = bookUserService.loginAsCustomer(bookUser);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}

