package com.example.mymodulith.userregistration.domain;


import com.example.mymodulith.common.events.UserRegisteredEvent;
import com.example.mymodulith.common.validator.EmailValidator;
import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.in.SaveUserLoginPort;
import com.example.mymodulith.login.infrastructure.adapter.in.LoginDto;
import com.example.mymodulith.userregistration.controller.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserRegistrationService {

  private UserRegistrationRepository userRegistrationRepository;
  private EmailValidator emailValidator;
  private SaveUserLoginPort userLogin;
  private ApplicationEventPublisher applicationEventPublisher;


  @Transactional
  public void registerUser(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(user.getUsername());
    userEntity.setFirstName(user.getFirstName());
    userEntity.setLastName(user.getLastName());
    userEntity.setEmail(user.getEmail());
    userRegistrationRepository.save(userEntity);

    userLogin.save(new Login(user.getUsername(), user.getPassword()));

    UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent();
    userRegisteredEvent.setEmail(user.getEmail());
    userRegisteredEvent.setFirstName(user.getFirstName());
    userRegisteredEvent.setLastName(user.getLastName());
    userRegisteredEvent.setEmail(user.getEmail());
    applicationEventPublisher.publishEvent(userRegisteredEvent);


  }

  public boolean verify(String userName) {
    Optional<UserEntity> userEntity = userRegistrationRepository.findById(userName);
    return userEntity.isPresent();
  }
}
