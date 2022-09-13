package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceAlreadyExistException;
import com.nesit.bookmyshow._springboot_resful_api.exception.ResourceNotFoundException;
import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.model.Role;
import com.nesit.bookmyshow._springboot_resful_api.repository.RoleRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.UserRepository;
import com.nesit.bookmyshow._springboot_resful_api.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public BookUser registerAsCustomer(BookUser bookUser) {
        BookUser user = userRepository.findByEmail(bookUser.getEmail());
        if (user != null) {
            throw new ResourceAlreadyExistException("User Already Exception");
        }
        Role role = roleRepository.findByName(Role.USER);
        bookUser.setRoles(Set.of(role));
        bookUser.setPassword(bCryptPasswordEncoder.encode(bookUser.getPassword()));
        return userRepository.save(bookUser);
    }

    public AuthResponse loginAsCustomer(BookUser bookUser) {
        BookUser user = userRepository.findByEmail(bookUser.getEmail());
        if (user != null && bCryptPasswordEncoder.matches(bookUser.getPassword(), user.getPassword())) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setName(user.getName());
            authResponse.setRole(user.getRoles().iterator().next().getName());
            authResponse.setUserId(user.getUserId());
            authResponse.setEmail(user.getEmail());
            return authResponse;
        }
        throw new ResourceNotFoundException("USer does not exists ");
    }
}

