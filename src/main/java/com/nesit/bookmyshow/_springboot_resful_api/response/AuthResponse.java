package com.nesit.bookmyshow._springboot_resful_api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Integer userId;
    private String name;
    private String email;
    private String role;
}
