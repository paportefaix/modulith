package com.example.mymodulith.userregistration.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface RegisterUserPort {

  void register(UserInformations userInformations);
}
