package com.nesit.bookmyshow._springboot_resful_api.repository;

import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
    Optional<Theatre> findByTheatreName(String theatreName);

    Optional<Theatre> findByTheatreId(Integer theatreId);
}
