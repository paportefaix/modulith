package com.example.mymodulith.login.application.port.in;

import org.jmolecules.ddd.annotation.ValueObject;
import org.springframework.modulith.NamedInterface;

@ValueObject
@NamedInterface("Login")
public record Login(String username, String password) {

}
