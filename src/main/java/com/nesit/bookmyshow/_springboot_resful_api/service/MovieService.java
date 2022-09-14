package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceAlreadyExistException;
import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.File;
import com.nesit.bookmyshow._springboot_resful_api.model.Movie;
import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.repository.BookingHistoryRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.FileRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.MovieRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.TheatreRepository;
import com.nesit.bookmyshow._springboot_resful_api.request.MovieRequest;
import com.nesit.bookmyshow._springboot_resful_api.response.MovieResponse;
import com.nesit.bookmyshow._springboot_resful_api.utils.ImageUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component

public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookingHistoryRepository bookingHistoryRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    FileRepository fileRepository;

    public Movie addMovie(MovieRequest movieRequest) {

        Movie movie = new Movie();

        File file = fileRepository.findById(movieRequest.getFileId())
                .orElseThrow(() -> new ResourceNotFoundException("file does not exist"));

        movie.setFile(file);
        movie.setMovieId(movieRequest.getMovieId());
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDescription(movieRequest.getDescription());
        movie.setPrice(movieRequest.getPrice());
        movie.setDate(movieRequest.getDate());

        Theatre theatre = theatreRepository.findById(movieRequest.getTheatreId())
                .orElseThrow(() -> new ResourceNotFoundException(""));

        List<Theatre> theatres = new ArrayList<>();
        theatres.add(theatre);

        movie.setTheatre(theatres);

        boolean isBookExists = movieRepository.findByMovieName(movie.getMovieName()).isPresent();
        if (isBookExists)
            throw new ResourceAlreadyExistException("Movie already exists.");

        File files = fileRepository.findById(movieRequest.getFileId())
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));

        movie.setFile(files);

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

    public List<MovieResponse> viewAllMovies() {

        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : movies) {
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setDescription(movie.getDescription());
            movieResponse.setMovieName(movie.getMovieName());
            movieResponse.setPrice(movie.getPrice());
            movieResponse.setDate(movie.getDate().toString());
            movieResponse.setMovieId(movie.getMovieId());
            movieResponse.setTheatreId(movie.getTheatre().iterator().next().getTheatreId());
            movieResponse.setDescription(movie.getDescription());
            if (movie.getFile() != null && movie.getFile().getImage() != null) {
                movie.getFile().setImage(ImageUtility.decompressImage(movie.getFile().getImage()));
                movieResponse.setFile(movie.getFile());
            }
            movieResponses.add(movieResponse);
        }
        return movieResponses;
    }

//    public List<BookingHistoryResponse> viewAllMovies() {
//
//        List<BookingHistory> bookingHistories = bookingHistoryRepository.findAll();
//        List<BookingHistoryResponse> bookingHistoryResponses = new ArrayList<>();
//
//        for (BookingHistory bookingHistory : bookingHistories) {
//            BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();
//
//            bookingHistoryResponse.setMovieId(bookingHistory.getMovie().getMovieId());
//            bookingHistoryResponse.setMovieName(bookingHistory.getMovie().getMovieName());
//            bookingHistoryResponse.setMovieName(bookingHistory.getMovie().getDescription());
//            bookingHistoryResponse.setDate(bookingHistory.getMovie().getDate().toString());
//            bookingHistoryResponse.setPrice(bookingHistory.getMovie().getPrice());
//
//            bookingHistoryResponse.setTickets(bookingHistory.getTickets());
//            bookingHistoryResponse.setTheatreId(bookingHistory.getTheatre().getTheatreId());
//            bookingHistoryResponse.setTheatreName(bookingHistory.getTheatre().getTheatreName());
//
//            bookingHistoryResponse.setUserId(bookingHistory.getBookUser().getUserId());
//            bookingHistoryResponses.add(bookingHistoryResponse);
//        }
//
//        return bookingHistoryResponses;
//
//
//    }


    public Movie findMovieById(Integer movieId) {
        return movieRepository.findByMovieId(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find movie with id " + movieId));
    }
}