package com.example.mymodulith.login.domain;

import com.example.mymodulith.login.infrastructure.adapter.out.persistence.LoginEntity;
import lombok.Getter;

import java.util.Optional;

public class LoginAggregate {

  @Getter
  private String username;
  @Getter
  private String password;

  private LoginAggregate(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static LoginAggregate load(Optional<LoginEntity> userLogin) throws Exception {
    if (userLogin.isEmpty()) {
      throw new Exception("User doesn't exist");
    }
    return new LoginAggregate(userLogin.get().getUsername(), userLogin.get().getPassword());
  }

  public static LoginAggregate create(String username, String password) {
    return new LoginAggregate(username, password);
  }

  public boolean isAuthenticated(String userPassword) {
    return userPassword.equals(password);
  }
}

