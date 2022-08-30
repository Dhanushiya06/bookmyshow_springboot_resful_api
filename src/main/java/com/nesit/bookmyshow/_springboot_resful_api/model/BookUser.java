package com.nesit.bookmyshow._springboot_resful_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @ManyToMany
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public BookUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
