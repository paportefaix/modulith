package com.example.mymodulith.login.application.usecases;

import com.example.mymodulith.login.application.port.in.AuthenticateUserPort;
import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.out.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticateUser implements AuthenticateUserPort {

  private LoginService loginService;

  @Override
  public boolean authenticate(Login login) throws Exception {
    var loginAggregation = loginService.loadLogin(login.username());
    return loginAggregation.isAuthenticated(login.password());
  }
}
