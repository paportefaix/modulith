package com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.service;

import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import com.example.mymodulith.userregistration.domain.User;
import com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.IUserRegistrationRepository;
import com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DomainUserRegistrationService implements UserRegistrationServicePort {

  private IUserRegistrationRepository iUserRegistrationRepository;

  @Override
  public void save(User user) {

    UserEntity userEntity = new UserEntity(
      user.getUsername(),
      user.getFirstName(),
      user.getLastName(),
      user.getEmail());
    iUserRegistrationRepository.save(userEntity);
  }

  @Override
  public boolean exist(String username) {
    return iUserRegistrationRepository.existsById(username);
  }
}
