package com.nesit.bookmyshow._springboot_resful_api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private Integer movieId;
    private String movieName;
    private Integer availableTickets;
    private Integer price;
    private String image;
    private String description;
    private Date date;
    private Integer theatreId;
}

