package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceAlreadyExistException;
import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.repository.MovieRepository;
import com.nesit.bookmyshow._springboot_resful_api.request.MovieRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        BeanUtils.copyProperties(movie, movie);

        boolean isBookExists = movieRepository.findByMovieName(movie.getMovieName()).isPresent();
        if (isBookExists)
            throw new ResourceAlreadyExistException("Movie already exists.");

        return movieRepository.save(movie);
    }

    public Movie updateMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieRequest, movie);
        if (movieRequest.getMovieId() == null)
            throw new ResourceNotFoundException("No movie with id "
                    + movieRequest.getMovieId());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Integer movieId) {
        movieRepository.findById(movieId).orElseThrow(() ->
                new ResourceNotFoundException("No movie with id "
                        + movieId));
        movieRepository.deleteById(movieId);
    }

    public List<Movie> viewAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(Integer movieId) {
        return movieRepository.findByMovieId(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find movie with id " + movieId));
    }
}