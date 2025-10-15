package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.in.SaveUserLoginPort;
import com.example.mymodulith.notification.application.in.UserRegisteredEvent;
import com.example.mymodulith.userregistration.application.port.in.RegisterUserPort;
import com.example.mymodulith.userregistration.application.port.in.UserInformations;
import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import com.example.mymodulith.userregistration.domain.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class RegisterUser implements RegisterUserPort {

  private final UserRegistrationServicePort userRegistrationServicePort;
  private final SaveUserLoginPort userLogin;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Transactional
  @Override
  public void register(UserInformations userInformations) {
    User aggregate = User.create(userInformations.username(),
      userInformations.firstName(),
      userInformations.lastName(),
      userInformations.email());

    userRegistrationServicePort.save(aggregate);
    userLogin.save(new Login(userInformations.username(), userInformations.password()));
    applicationEventPublisher.publishEvent(new UserRegisteredEvent(userInformations.email(), userInformations.firstName(), userInformations.lastName()));
  }
}
