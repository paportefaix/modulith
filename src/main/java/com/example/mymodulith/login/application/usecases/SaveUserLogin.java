package com.example.mymodulith.login.application.usecases;

import com.example.mymodulith.login.application.port.in.Login;
import com.example.mymodulith.login.application.port.in.SaveUserLoginPort;
import com.example.mymodulith.login.application.port.out.LoginServicePort;
import com.example.mymodulith.login.domain.LoginAggregate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SaveUserLogin implements SaveUserLoginPort {

  private LoginServicePort loginServicePort;

  @Override
  public void save(Login login) {
    var aggregate = LoginAggregate.create(login.username(), login.password());
    loginServicePort.save(aggregate);
  }
}
