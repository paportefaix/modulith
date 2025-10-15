package com.example.mymodulith.userregistration.application.port.out;

import com.example.mymodulith.userregistration.domain.User;

public interface UserRegistrationServicePort {

  void save(User userEntity);

  boolean exist(String username);
}
