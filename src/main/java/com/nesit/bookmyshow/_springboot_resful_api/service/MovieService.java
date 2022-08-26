package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> viewMovie() {

        return null;
    }
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(int id) {

    }
}
