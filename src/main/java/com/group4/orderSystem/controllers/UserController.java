package com.group4.orderSystem.controllers;


import com.group4.orderSystem.models.User;
import com.group4.orderSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService service;

    //Get all users
    @GetMapping("/users")
    public List<User> listUsers() { return service.listAllUsers(); };

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getItem(@PathVariable Long id) {
        try {
            User user= service.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    //Post new User
    @PostMapping("/users")
    public void addUser(@RequestBody User user) { service.save(user); };
}
