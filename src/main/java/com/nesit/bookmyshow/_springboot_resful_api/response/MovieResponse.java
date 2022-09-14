package com.nesit.bookmyshow._springboot_resful_api.response;

import com.nesit.bookmyshow._springboot_resful_api.model.File;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponse {
    private Integer movieId;
    private Integer theatreId;
    private String movieName;
    private Integer price;
    private String description;
    private String date;
    private File file;
}
