package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.in.SaveUserLoginPort;
import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import com.example.mymodulith.userregistration.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.*;

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

    Mockito.doNothing().when(userRegistrationServicePort).save(Mockito.any(User.class));
    Mockito.doNothing().when(userLogin).save(Mockito.any(Login.class));
  }
}
