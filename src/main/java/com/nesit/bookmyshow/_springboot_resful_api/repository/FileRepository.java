package com.nesit.bookmyshow._springboot_resful_api.repository;


import com.nesit.bookmyshow._springboot_resful_api.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
