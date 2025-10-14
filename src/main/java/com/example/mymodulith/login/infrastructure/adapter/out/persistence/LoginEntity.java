package com.example.mymodulith.login.infrastructure.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoginEntity {

  @Id
  private String username;
  private String password;
}
