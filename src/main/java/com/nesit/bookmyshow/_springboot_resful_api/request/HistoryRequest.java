package com.nesit.bookmyshow._springboot_resful_api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequest {
    private Integer userId;
    private Integer movieId;
    private Integer theatreId;
    private Integer tickets;
}
