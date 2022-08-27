package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue
    private Integer theatreId;
    private String theatreName;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "theatre_movie",
            joinColumns = @JoinColumn(name = "theatre_id", referencedColumnName = "theatreId"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieId"))
    private List<Movie> movie;

}
