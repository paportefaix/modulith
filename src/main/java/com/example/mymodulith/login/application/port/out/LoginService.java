package com.example.mymodulith.login.application.port.out;

import com.example.mymodulith.login.domain.LoginAggregate;

public interface LoginService {

  LoginAggregate loadLogin(String username) throws Exception;

  void save(LoginAggregate loginAggregate);
}
