package com.nesit.bookmyshow._springboot_resful_api.repository;

import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BookUser, Integer> {
    BookUser findByEmail(String email);
}
