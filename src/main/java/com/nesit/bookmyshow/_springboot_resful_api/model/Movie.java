package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue
    private Integer movieId;
    private String movieName;
    private Integer availableTickets;
    private Integer price;
    private String image;
    private String description;
    private Date date;
}
