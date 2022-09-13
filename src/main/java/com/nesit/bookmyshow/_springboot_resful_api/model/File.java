package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue
    private Integer id;
    private String Location;

    @OneToOne(mappedBy = "file")
    private Movie movie;

}
