package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceAlreadyExistException;
import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.repository.MovieRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.TheatreRepository;
import com.nesit.bookmyshow._springboot_resful_api.request.TheatreRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private MovieRepository movieRepository;

    public Theatre addTheatre(Theatre theatre) {
        boolean isBookExists = theatreRepository.findByTheatreName(theatre.getTheatreName()).isPresent();
        if (isBookExists)
            throw new ResourceAlreadyExistException("Theatre already exists.");

        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(TheatreRequest theatreRequest) {
        Theatre theatre = new Theatre();
        BeanUtils.copyProperties(theatreRequest, theatre);
        if (theatreRequest.getTheatreId() == null)
            throw new ResourceNotFoundException("No theatre with id "
                    + theatreRequest.getTheatreId());
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Integer theatreId) {
        theatreRepository.findById(theatreId).orElseThrow(() ->
                new ResourceNotFoundException("No theatre with id "
                        + theatreId));
        theatreRepository.deleteById(theatreId);
    }

    public List<Theatre> viewAllTheatre() {
        return theatreRepository.findAll();
    }

    public Theatre findTheatreById(Integer theatreId) {
        return theatreRepository.findByTheatreId(theatreId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find theatre with id " + theatreId));
    }




    public List<Theatre> findTheatreByMovieId(Integer movieId) {
        movieRepository.findById(movieId).orElseThrow(() ->
                new ResourceNotFoundException("No movie with id "
                        + movieId));
        Theatre theatre = new Theatre();
        theatreRepository.findById(theatre.getTheatreId()).orElseThrow(() ->
                new ResourceNotFoundException("No theatre with id "
                        + theatre.getTheatreId()));

       theatreRepository.findById(movieId);
       return null;
    }
}


