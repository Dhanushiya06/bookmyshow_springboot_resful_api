package com.nesit.bookmyshow._springboot_resful_api.repository;

import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.model.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {
    List<BookingHistory> findByBookUser(BookUser bookUser);
}
