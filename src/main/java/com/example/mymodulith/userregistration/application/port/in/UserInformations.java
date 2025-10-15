package com.example.mymodulith.userregistration.application.port.in;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record UserInformations(String username, String password, String email, String firstName, String lastName) {
}
