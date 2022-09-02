package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.service.MovieService;
import com.nesit.bookmyshow._springboot_resful_api.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    private MovieService movieService;

    @PostMapping
    public void addTheatre(@RequestBody Theatre theatre) {
        theatreService.addTheatre(theatre);
    }

    @GetMapping("/all")
    public List<Theatre> viewTheatre() {
        return theatreService.viewTheatre();
    }

    @PutMapping
    public void updateTheatre(Theatre theatre) {
        theatreService.updateTheatre(theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable int id) {
        theatreService.deleteTheatre(2);
    }

    @GetMapping("/{id}")
    public void viewTheatre(@PathVariable int movieId) {
        theatreService.viewTheatre();


    }
}
