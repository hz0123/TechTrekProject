package com.techtrek5.backend.authentication.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class RegistrationModel {
    private final String username;
    private final String password;
    private final String name;
    private final String appointment;
}
