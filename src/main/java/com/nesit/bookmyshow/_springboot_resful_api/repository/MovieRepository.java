package com.nesit.bookmyshow._springboot_resful_api.repository;

import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
