package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.dto.MovieDto;
import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping("/all")
    public List<Movie> viewMovie() {
        return movieService.viewMovie();
    }

    @PutMapping
    public void updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(1);
    }

    @GetMapping("/{id}")
    public void viewMovie(@PathVariable int id) {
        movieService.viewMovie(3);
    }

}
