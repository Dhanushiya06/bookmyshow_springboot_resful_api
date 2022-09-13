package com.nesit.bookmyshow._springboot_resful_api.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingHistoryResponse {
    private Integer userId;
    private Integer movieId;
    private Integer theatreId;
    private String movieName;
    private String description;
    private String theatreName;
    private Integer price;
    private Integer tickets;
    private String date;
}
