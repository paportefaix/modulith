package com.example.mymodulith.login.application.usecases;

import com.example.mymodulith.login.application.port.in.AuthenticateUserPort;
import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.out.LoginServicePort;
import lombok.AllArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AuthenticateUser implements AuthenticateUserPort {

  private LoginServicePort loginServicePort;

  @Override
  public boolean authenticate(Login login) throws Exception {
    var loginAggregation = loginServicePort.loadLogin(login.username());
    return loginAggregation.isAuthenticated(login.password());
  }
}
