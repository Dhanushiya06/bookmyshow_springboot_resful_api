package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public void addTheatre(Theatre theatre) {
        theatreRepository.save(theatre);

    }

    public List<Theatre> viewTheatre() {
        return null;
    }
    public void updateTheatre(Theatre theatre){
        theatreRepository.save(theatre);

    }
    public void deleteTheatre(int id){

    }
}
