package com.group4.orderSystem.misc;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String name;
    private final String username;
    private final String password;
    private final String email;
}
