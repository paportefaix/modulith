package com.example.mymodulith.login.application.port.in;

import org.springframework.modulith.NamedInterface;


@NamedInterface("AuthenticateUserPort")
public interface AuthenticateUserPort {

  boolean authenticate(Login login) throws Exception;

}
