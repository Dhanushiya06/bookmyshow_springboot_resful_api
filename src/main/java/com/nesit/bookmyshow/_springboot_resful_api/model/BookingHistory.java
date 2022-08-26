package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistory {
    private Date date;
    private Movie movie;
    private Integer noOfTickets;

}
