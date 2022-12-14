package com.nesit.bookmyshow._springboot_resful_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue
    private Integer theatreId;
    private String theatreName;
    private Integer tickets;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "theatre_movie",
            joinColumns = @JoinColumn(name = "theatre_id", referencedColumnName = "theatreId"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieId"))
    private List<Movie> movie;

    @JsonIgnore
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<BookingHistory> bookingHistory;


}
