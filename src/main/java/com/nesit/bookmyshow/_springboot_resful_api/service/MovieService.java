package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.dto.MovieDto;
import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.repository.MovieRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie>viewMovie() {

        return movieRepository.findAll();
    }

    public void viewMovie(int id) {
        Movie movie = movieRepository.findById(id).get();
        movieRepository.findAll().get(id);

    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);


    }
}
