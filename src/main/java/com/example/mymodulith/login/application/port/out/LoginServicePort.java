package com.example.mymodulith.login.application.port.out;

import com.example.mymodulith.login.domain.LoginAggregate;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface LoginServicePort {

  LoginAggregate loadLogin(String username) throws Exception;

  void save(LoginAggregate loginAggregate);
}
