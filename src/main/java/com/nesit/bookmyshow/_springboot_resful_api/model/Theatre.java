package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue
    private Integer theatreId;
    private List<Movie> movie;
    private Integer tickets;
    private Integer price;

}
