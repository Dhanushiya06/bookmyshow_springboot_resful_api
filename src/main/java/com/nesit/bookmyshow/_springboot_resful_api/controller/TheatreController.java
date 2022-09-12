package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.Role;
import com.nesit.bookmyshow._springboot_resful_api.model.Theatre;
import com.nesit.bookmyshow._springboot_resful_api.request.TheatreRequest;
import com.nesit.bookmyshow._springboot_resful_api.response.APIResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.SuccessResponse;
import com.nesit.bookmyshow._springboot_resful_api.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private APIResponse apiResponse;

//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> addTheatre(@RequestBody Theatre theatre) {
        Theatre addedTheatre = theatreService.addTheatre(theatre);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(addedTheatre);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updateTheatre(@RequestBody TheatreRequest theatreRequest) {
        Theatre updatedTheatre = theatreService.updateTheatre( theatreRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedTheatre);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{theatreId}")
    public ResponseEntity<APIResponse> deleteTheatre(@PathVariable Integer theatreId) {
       theatreService.deleteTheatre(theatreId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllTheatre() {
        List<Theatre>theatres =theatreService.viewAllTheatre();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(theatres);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


//    @Secured({Role.ADMIN, Role.ROLE_USER})
    @GetMapping("/{bookId}")
    public ResponseEntity<APIResponse> findTheatreById(@PathVariable Integer theatreId) {
       Theatre theatre = theatreService.findTheatreById(theatreId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(theatre);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
