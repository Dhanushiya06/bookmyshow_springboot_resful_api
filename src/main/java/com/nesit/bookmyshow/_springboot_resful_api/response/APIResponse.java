package com.nesit.bookmyshow._springboot_resful_api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse {
    private Integer status;
    private LocalDateTime timestamp;
    private Object data;
    private ErrorResponse error;

    public APIResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public APIResponse(Integer status, Object data, ErrorResponse error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }
}
