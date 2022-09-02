package com.nesit.bookmyshow._springboot_resful_api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private String description;

    public ErrorResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
