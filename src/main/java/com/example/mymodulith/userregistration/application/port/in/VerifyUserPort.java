package com.example.mymodulith.userregistration.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;


@PrimaryPort
public interface VerifyUserPort {

  boolean verifyUser(String username);
}
