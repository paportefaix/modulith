package com.example.mymodulith.userregistration.application.port.out;

import com.example.mymodulith.userregistration.domain.User;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface UserRegistrationServicePort {

  void save(User userEntity);

  boolean exist(String username);
}
