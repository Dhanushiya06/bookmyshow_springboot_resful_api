package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    private Integer movieId;
    private String movieName;
    private Integer availableTickets;
    private Integer price;
    private String image;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Theatre> theatre;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<BookingHistory> bookingHistory;

}
