package com.nesit.bookmyshow._springboot_resful_api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TheatreRequest {
    private Integer theatreId;
    private String theatreName;
    private Integer movieId;
    private String movieName;
    private String description;
    private Integer availableTickets;
    private Integer price;
    private String image;
    private Date date;

}

