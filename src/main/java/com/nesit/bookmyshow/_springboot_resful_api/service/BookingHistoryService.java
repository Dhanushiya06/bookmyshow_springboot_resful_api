package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.model.BookingHistory;
import com.nesit.bookmyshow._springboot_resful_api.repository.BookingHistoryRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.UserRepository;
import com.nesit.bookmyshow._springboot_resful_api.response.BookingHistoryResponse;
import org.hibernate.hql.internal.ast.tree.IdentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingHistoryService {

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BookingHistoryResponse> viewAllBookingHistories() {
        List<BookingHistory> bookingHistories = bookingHistoryRepository.findAll();
        List<BookingHistoryResponse> bookingHistoryResponses = new ArrayList<>();

        for (BookingHistory bookingHistory : bookingHistories) {
            BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();

            bookingHistoryResponse.setDate(bookingHistory.getMovie().getDate().toString());
            bookingHistoryResponse.setPrice(bookingHistory.getMovie().getPrice());
            bookingHistoryResponse.setMovieId(bookingHistory.getMovie().getMovieId());
            bookingHistoryResponse.setMovieName(bookingHistory.getMovie().getMovieName());

            bookingHistoryResponse.setTickets(bookingHistory.getTheatre().getTickets());
            bookingHistoryResponse.setTheatreId(bookingHistory.getTheatre().getTheatreId());
            bookingHistoryResponse.setTheatreName(bookingHistory.getTheatre().getTheatreName());

            bookingHistoryResponse.setUserId(bookingHistory.getBookUser().getUserId());
            bookingHistoryResponses.add(bookingHistoryResponse);
        }

        return bookingHistoryResponses;
    }

    public List<BookingHistoryResponse> viewBookingHistoryById(Integer id) {
        BookUser bookUser = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist!"));
        List<BookingHistory> bookingHistories = bookingHistoryRepository.findByBookUser(bookUser);

        List<BookingHistoryResponse> bookingHistoryResponses = new ArrayList<>();

        for (BookingHistory bookingHistory : bookingHistories) {
            BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();

            bookingHistoryResponse.setDate(bookingHistory.getMovie().getDate().toString());
            bookingHistoryResponse.setPrice(bookingHistory.getMovie().getPrice());
            bookingHistoryResponse.setMovieId(bookingHistory.getMovie().getMovieId());
            bookingHistoryResponse.setMovieName(bookingHistory.getMovie().getMovieName());

            bookingHistoryResponse.setTickets(bookingHistory.getTheatre().getTickets());
            bookingHistoryResponse.setTheatreId(bookingHistory.getTheatre().getTheatreId());
            bookingHistoryResponse.setTheatreName(bookingHistory.getTheatre().getTheatreName());

            bookingHistoryResponse.setUserId(bookingHistory.getBookUser().getUserId());
            bookingHistoryResponses.add(bookingHistoryResponse);
        }

        return bookingHistoryResponses;
    }
}
