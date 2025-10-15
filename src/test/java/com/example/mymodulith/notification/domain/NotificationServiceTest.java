package com.example.mymodulith.notification.domain;

import com.example.mymodulith.notification.application.in.UserRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.STANDALONE)
class NotificationServiceTest {

  @MockitoBean
  private NotificationService notificationService;

  @Test
  void testListener(Scenario scenario) {
    var event = new UserRegisteredEvent("email@example.com", "firstname", "lastname");
    // Publie l'événement dans le contexte Spring Modulith
    scenario.publish(event)
      .andWaitForEventOfType(UserRegisteredEvent.class)
      .toArriveAndVerify(ctx -> {
        // Vérifie que le listener a bien été déclenché
        verify(notificationService, times(1)).handle(event);
      });
  }

}
