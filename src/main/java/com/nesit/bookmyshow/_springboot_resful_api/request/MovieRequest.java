package com.nesit.bookmyshow._springboot_resful_api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieRequest {
    private Integer movieId;
    private Integer theatreId;
    private Integer fileId;
    private String movieName;
    private Integer availableTickets;
    private Integer price;
    private String description;
    private Date date;
}
