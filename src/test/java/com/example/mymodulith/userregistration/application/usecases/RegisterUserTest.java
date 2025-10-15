package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.in.SaveUserLoginPort;
import com.example.mymodulith.notification.application.in.UserRegisteredEvent;
import com.example.mymodulith.userregistration.application.port.in.UserInformations;
import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import com.example.mymodulith.userregistration.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.test.Scenario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterUserTest {

  @Mock
  private UserRegistrationServicePort userRegistrationServicePort;
  @Mock
  private SaveUserLoginPort userLogin;
  @Mock
  private ApplicationEventPublisher applicationEventPublisher;
  @InjectMocks
  private RegisterUser registerUser;


  @Test
  void register() {

    doNothing().when(userRegistrationServicePort).save(any(User.class));
    doNothing().when(userLogin).save(any(Login.class));
    doNothing().when(applicationEventPublisher).publishEvent(any(UserRegisteredEvent.class));

    registerUser.register(new UserInformations("username", "password", "email@example.com", "firstname","lastname"));

    // check only class type because it's the aggregate in parameter and the test of aggregate's value it's not here
    verify(userRegistrationServicePort, times(1)).save(any(User.class));

    // check the parameter transmitted to Login
    ArgumentCaptor<Login> loginArgumentCaptor = ArgumentCaptor.forClass(Login.class);
    verify(userLogin, times(1)).save(loginArgumentCaptor.capture());
    Assertions.assertEquals(new Login("username", "password"), loginArgumentCaptor.getValue());

    // check the parameter transmitted to event UserRegisteredEvent
    ArgumentCaptor<UserRegisteredEvent> eventArgumentCaptor = ArgumentCaptor.forClass(UserRegisteredEvent.class);
    verify(applicationEventPublisher, times(1)).publishEvent(eventArgumentCaptor.capture());
    Assertions.assertEquals(new UserRegisteredEvent("email@example.com", "firstname", "lastname"), eventArgumentCaptor.getValue());


  }
}
