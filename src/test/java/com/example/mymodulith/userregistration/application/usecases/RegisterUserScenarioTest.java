package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.notification.application.in.UserRegisteredEvent;
import com.example.mymodulith.userregistration.application.port.in.UserInformations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
public class RegisterUserScenarioTest {

  @Autowired
  private RegisterUser registerUser;


  @Test
  void testPublishedEvent(Scenario scenario) {
    scenario.stimulate(() -> registerUser.register(new UserInformations("username", "password", "email@example.com", "firstname", "lastname")))
      .andWaitForEventOfType(UserRegisteredEvent.class)
      .toArriveAndVerify((userRegisteredEvent, unused) -> {
        Assertions.assertEquals("email@example.com", userRegisteredEvent.email());
        Assertions.assertEquals("firstname", userRegisteredEvent.firstName());
        Assertions.assertEquals("lastname", userRegisteredEvent.lastName());
      });
  }
}
