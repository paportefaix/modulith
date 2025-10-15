package com.example.mymodulith.notification.domain;

import com.example.mymodulith.notification.application.in.UserRegisteredEvent;
import org.jmolecules.event.annotation.DomainEventHandler;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

  @DomainEventHandler
  @ApplicationModuleListener
  public void handle(UserRegisteredEvent event) {

    System.out.println("User registered event received:");
    System.out.println("Email: " + event.email());
    System.out.println("First Name: " + event.firstName());
    System.out.println("Last Name: " + event.lastName());
  }
}
