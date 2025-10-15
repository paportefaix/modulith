package com.example.mymodulith.userregistration.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.springframework.modulith.NamedInterface;

@NamedInterface("VerifyUserPort")
@PrimaryPort
public interface VerifyUserPort {

  boolean verifyUser(String username);
}
