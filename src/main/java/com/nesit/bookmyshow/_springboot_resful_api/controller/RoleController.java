package com.nesit.bookmyshow._springboot_resful_api.controller;

import com.nesit.bookmyshow._springboot_resful_api.model.Role;
import com.nesit.bookmyshow._springboot_resful_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }
}
