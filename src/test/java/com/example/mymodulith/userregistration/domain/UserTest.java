package com.example.mymodulith.userregistration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

  @Test
  void createUser() {
    User user = User.create("username", "firstName", "lastName", "me@email.com");

    Assertions.assertEquals("username", user.getUsername());
    Assertions.assertEquals("firstName", user.getFirstName());
    Assertions.assertEquals("lastName", user.getLastName());
    Assertions.assertEquals("me@email.com", user.getEmail());
  }

  @ParameterizedTest
  @ValueSource(strings = {"me", "me.to"})
  @NullSource
  void emailNotValid(String email){

    Exception exception = assertThrows(Exception.class, () -> {
      User.create("username", "firstName", "lastName", email);
    });
    assertTrue(exception.getMessage().contains("Email not valid"));

  }
}
