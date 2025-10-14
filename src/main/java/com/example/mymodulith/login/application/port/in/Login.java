package com.example.mymodulith.login.application.port.in;

import org.springframework.modulith.NamedInterface;


@NamedInterface("Login")
public record Login(String username, String password) {

}
