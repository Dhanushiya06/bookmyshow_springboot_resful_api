package com.nesit.bookmyshow._springboot_resful_api.exception;

import com.nesit.bookmyshow._springboot_resful_api.response.APIResponse;
import com.nesit.bookmyshow._springboot_resful_api.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private APIResponse apiResponse;

    public ControllerExceptionHandler() {
        this.apiResponse = new APIResponse();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false));
        apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiResponse.setError(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<APIResponse> userExistException(UserExistException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false));

        apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiResponse.setError(message);

        System.out.println(apiResponse.toString());

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false));

        apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiResponse.setError(message);

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}