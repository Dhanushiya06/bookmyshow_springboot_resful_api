package com.nesit.bookmyshow._springboot_resful_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue
    private Integer id;
//    private String Location;

    @JsonIgnore
    @OneToOne(mappedBy = "file")
    private Movie movie;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;
}
