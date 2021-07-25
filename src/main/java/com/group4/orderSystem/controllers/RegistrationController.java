package com.group4.orderSystem.controllers;

import com.group4.orderSystem.misc.RegistrationRequest;
import com.group4.orderSystem.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService service;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return service.register(request);
    }
}
