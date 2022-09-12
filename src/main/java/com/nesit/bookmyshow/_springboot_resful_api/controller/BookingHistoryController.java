package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.BookingHistory;
import com.nesit.bookmyshow._springboot_resful_api.response.APIResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.BookingHistoryResponse;
import com.nesit.bookmyshow._springboot_resful_api.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/history")
public class BookingHistoryController {
    @Autowired
    private BookingHistoryService bookingHistoryService;
    @Autowired
    private APIResponse apiResponse;


    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllBookingHistories() {
        List<BookingHistoryResponse> bookingHistories = bookingHistoryService.viewAllBookingHistories();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingHistories);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> viewBookingHistoryById(@PathVariable Integer id) {
        List<BookingHistoryResponse> bookingHistories = bookingHistoryService.viewBookingHistoryById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingHistories);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
