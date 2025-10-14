package com.example.mymodulith.login.application.useCase;

import com.example.mymodulith.login.application.port.in.AuthenticateUserPort;
import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.out.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticateUser implements AuthenticateUserPort {

  private LoginRepository loginRepository;

  @Override
  public boolean authenticate(Login login) throws Exception {
    var loginAggregation = loginRepository.loadLogin(login.username());
    return loginAggregation.isAuthenticated(login.password());
  }
}
