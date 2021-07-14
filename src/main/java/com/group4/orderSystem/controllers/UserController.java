package com.group4.orderSystem.controllers;


import com.group4.orderSystem.models.User;
import com.group4.orderSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService service;

    //Get all users
    @GetMapping("/users")
    public List<User> listUsers() { return service.listAllUsers(); };
}
