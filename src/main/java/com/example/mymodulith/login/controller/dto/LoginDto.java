package com.example.mymodulith.login.controller.dto;

import org.springframework.modulith.NamedInterface;

@NamedInterface("LoginDto")
public record LoginDto(String username, String password) {
}
