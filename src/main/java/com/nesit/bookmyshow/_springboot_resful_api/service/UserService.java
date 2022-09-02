package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.BookUser;
import com.nesit.bookmyshow._springboot_resful_api.model.Role;
import com.nesit.bookmyshow._springboot_resful_api.repository.RoleRepository;
import com.nesit.bookmyshow._springboot_resful_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public BookUser registerAsCustomer(BookUser bookUser) {
        Role role = roleRepository.findByName(Role.ROLE_USER);
        bookUser.setRoles(Set.of(role));
        bookUser.setPassword(bCryptPasswordEncoder.encode(bookUser.getPassword()));
        return userRepository.save(bookUser);
    }

    public List<BookUser> getAllUsers() {
        return userRepository.findAll();
    }

    public BookUser loginAsCustomer(BookUser bookUser) {
        BookUser user = userRepository.findByEmail(bookUser.getEmail());
        if (user != null && (bCryptPasswordEncoder.matches(bookUser.getPassword(), user.getPassword()))) {
            return user;
        }
        return null;
    }
}
