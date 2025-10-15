package com.example.mymodulith.notification.application.in;

import org.springframework.modulith.NamedInterface;

@NamedInterface("UserRegisteredEvent")
public record UserRegisteredEvent(String email, String firstName, String lastName) {

}
