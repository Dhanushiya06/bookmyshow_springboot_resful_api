package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.model.Role;
import com.nesit.bookmyshow._springboot_resful_api.request.MovieRequest;
import com.nesit.bookmyshow._springboot_resful_api.response.APIResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.BookingHistoryResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.MovieResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.SuccessResponse;
import com.nesit.bookmyshow._springboot_resful_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private APIResponse apiResponse;

//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        Movie addedMovie = movieService.addMovie(movieRequest);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(addedMovie);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updateMovie(@RequestBody MovieRequest movieRequest) {
        Movie updatedMovie = movieService.updateMovie(movieRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedMovie);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{movieId}")
    public ResponseEntity<APIResponse> deleteMovie(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(movieService.viewAllMovies());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllMovies() {
//        List<BookingHistoryResponse> movies = movieService.viewAllMovies();
        List<MovieResponse> movies = movieService.viewAllMovies();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(movies);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/{bookId}")
    public ResponseEntity<APIResponse> findMovieById(@PathVariable Integer movieId) {
        Movie movie = movieService.findMovieById(movieId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(movie);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
