package com.group4.orderSystem.services;

import com.group4.orderSystem.misc.RegistrationRequest;
import com.group4.orderSystem.models.User;
import com.group4.orderSystem.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator validator;
    private final UserService service;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = validator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        return service.registerUser(
                new User(
                        request.getEmail(),
                        request.getName(),
                        request.getUsername(),
                        request.getPassword(),
                        ApplicationUserRole.BUYER
                )
        );

    }

    public String registerAdmin(RegistrationRequest request) {
        boolean isValidEmail = validator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        return service.registerUser(
                new User(
                        request.getEmail(),
                        request.getName(),
                        request.getUsername(),
                        request.getPassword(),
                        ApplicationUserRole.ADMIN
                )
        );

    }
}
