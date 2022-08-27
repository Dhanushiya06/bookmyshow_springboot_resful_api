package com.nesit.bookmyshow._springboot_resful_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class BookUser {
    @Id
    @GeneratedValue
    private Integer userId;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "bookUser", cascade = CascadeType.ALL)
    private Set<BookingHistory> bookingHistories;

}
