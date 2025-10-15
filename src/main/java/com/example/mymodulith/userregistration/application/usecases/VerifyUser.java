package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.userregistration.application.port.in.VerifyUserPort;
import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VerifyUser implements VerifyUserPort {

  private final UserRegistrationServicePort userRegistrationServicePort;

  @Override
  public boolean verifyUser(String username) {
    return userRegistrationServicePort.exist(username);
  }
}
