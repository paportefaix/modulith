package com.example.mymodulith.login.application.port.in;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.springframework.modulith.NamedInterface;

@PrimaryPort
@NamedInterface("AuthenticateUserPort")
public interface AuthenticateUserPort {

  boolean authenticate(Login login) throws Exception;

}
