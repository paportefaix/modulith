package com.example.mymodulith.login.domain;

import com.example.mymodulith.login.infrastructure.adapter.out.persistence.LoginEntity;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

@AggregateRoot
public class LoginAggregate {

  @Getter

  private final String username;
  @Getter
  private final String password;

  private LoginAggregate(String username, String password) {
    this.username = username;
    this.password = password;
  }


  public static LoginAggregate load(LoginEntity userLogin) throws Exception {
    if (userLogin == null) {
      throw new Exception("User doesn't exist");
    }
    return new LoginAggregate(userLogin.getUsername(), userLogin.getPassword());
  }

  public static LoginAggregate create(String username, String password) {
    return new LoginAggregate(username, password);
  }

  public boolean isAuthenticated(String userPassword) {
    return userPassword.equals(password);
  }
}

