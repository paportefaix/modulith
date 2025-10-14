package com.example.mymodulith.login.application.port.in;


public interface AuthenticateUserPort {

  boolean authenticate(Login login) throws Exception;

}
