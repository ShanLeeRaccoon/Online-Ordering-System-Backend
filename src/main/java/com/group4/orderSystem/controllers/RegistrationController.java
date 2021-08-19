package com.group4.orderSystem.controllers;

import com.group4.orderSystem.misc.RegistrationRequest;
import com.group4.orderSystem.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// This controller is currently bugged and will not work correctly when connected to a client. For a more
// stable, but with less security features, use a post request with endpoint "/users" to register the new user.

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

    @PostMapping("/admin")
    public String registerAdmin(@RequestBody RegistrationRequest request) {
        return service.registerAdmin(request);
    }
}
