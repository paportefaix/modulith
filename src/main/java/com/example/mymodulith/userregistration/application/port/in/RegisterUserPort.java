package com.example.mymodulith.userregistration.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.springframework.modulith.NamedInterface;

@NamedInterface("RegisterUserPort")
@PrimaryPort
public interface RegisterUserPort {

  void register(UserInformations userInformations);
}
