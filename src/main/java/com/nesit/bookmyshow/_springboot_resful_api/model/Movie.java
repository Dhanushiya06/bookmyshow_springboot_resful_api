package com.nesit.bookmyshow._springboot_resful_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    private Integer movieId;
    private String movieName;
    private Integer price;
    private String image;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    @JsonIgnore
    @ManyToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Theatre> theatre;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<BookingHistory> bookingHistory;

}
