package com.example.mymodulith.login.application.port.in;

import org.springframework.modulith.NamedInterface;

@NamedInterface("SaveUserLoginPort")
public interface SaveUserLoginPort {

  void save(Login login);
}
