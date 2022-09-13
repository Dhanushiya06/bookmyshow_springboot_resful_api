package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookingHistory")
public class BookingHistory {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer tickets;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private BookUser bookUser;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "theatreId")
    private Theatre theatre;
}

