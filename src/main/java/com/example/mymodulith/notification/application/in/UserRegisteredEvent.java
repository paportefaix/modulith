package com.example.mymodulith.notification.application.in;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.modulith.NamedInterface;

@ValueObject
@DomainEvent
@NamedInterface("UserRegisteredEvent")
public record UserRegisteredEvent(String email, String firstName, String lastName) {

}
