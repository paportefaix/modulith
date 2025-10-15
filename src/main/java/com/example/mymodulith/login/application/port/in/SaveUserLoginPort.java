package com.example.mymodulith.login.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.springframework.modulith.NamedInterface;

@PrimaryPort
@NamedInterface("SaveUserLoginPort")
public interface SaveUserLoginPort {

  void save(Login login);
}
