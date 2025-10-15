package com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.service;

import com.example.mymodulith.userregistration.domain.User;
import com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.IUserRegistrationRepository;
import com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DomainUserRegistrationServiceTest {

  @InjectMocks
  private DomainUserRegistrationService domainUserRegistrationService;

  @Mock
  private IUserRegistrationRepository iUserRegistrationRepository;

  @Test
  void save() {

    Mockito.when(iUserRegistrationRepository.save(Mockito.any(UserEntity.class))).thenReturn(new UserEntity());
    domainUserRegistrationService.save(User.create("username", "firstname", "lastname", "email@maill.com"));

    ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);
    Mockito.verify(iUserRegistrationRepository, Mockito.times(1)).save(userEntityArgumentCaptor.capture());

    UserEntity userEntity = userEntityArgumentCaptor.getValue();

    Assertions.assertEquals("username", userEntity.getUsername());
    Assertions.assertEquals("firstname", userEntity.getFirstName());
    Assertions.assertEquals("lastname", userEntity.getLastName());
    Assertions.assertEquals("email@maill.com", userEntity.getEmail());

  }

  @Test
  void exist() {
  }
}
