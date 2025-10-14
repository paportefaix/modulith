package com.example.mymodulith.userregistration.domain;


import com.example.mymodulith.common.events.UserRegisteredEvent;
import com.example.mymodulith.common.validator.EmailValidator;
import com.example.mymodulith.login.LoginService;
import com.example.mymodulith.login.controller.dto.LoginDto;
import com.example.mymodulith.userregistration.controller.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private UserRegistrationRepository userRegistrationRepository;


    private EmailValidator emailValidator;

    LoginService loginService;

    ApplicationEventPublisher applicationEventPublisher;

    UserRegistrationService(@Autowired LoginService loginService, @Autowired EmailValidator emailValidator, @Autowired UserRegistrationRepository userRegistrationRepository,@Autowired ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userRegistrationRepository = userRegistrationRepository;
        this.emailValidator = emailValidator;
        this.loginService = loginService;
    }

    @Transactional
    public void registerUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userRegistrationRepository.save(userEntity);

        LoginDto loginDTO = new LoginDto(user.getUsername(), user.getPassword());
        loginService.saveLogin(loginDTO);

        UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent();
        userRegisteredEvent.setEmail(user.getEmail());
        userRegisteredEvent.setFirstName(user.getFirstName());
        userRegisteredEvent.setLastName(user.getLastName());
        userRegisteredEvent .setEmail(user.getEmail());
        applicationEventPublisher.publishEvent(userRegisteredEvent);


    }

    public boolean verify(String userName) {
        Optional<UserEntity> userEntity = userRegistrationRepository.findById(userName);
        return userEntity.isPresent();
    }
}
