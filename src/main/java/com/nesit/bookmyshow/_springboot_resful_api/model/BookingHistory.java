package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookingHistory")
public class BookingHistory {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movie movie;
    private Integer noOfTickets;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private BookUser bookUser;
}

