package com.example.mymodulith.userregistration.application.usecases;

import com.example.mymodulith.userregistration.application.port.out.UserRegistrationServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VerifyUserTest {

  @Mock
  private UserRegistrationServicePort userRegistrationServicePort;

  @InjectMocks
  private VerifyUser verifyUser;

  @Test
  void verifyUser() {
    when(userRegistrationServicePort.exist(eq("anything"))).thenReturn(true);
    verifyUser.verifyUser("anything");
    verify(userRegistrationServicePort, times(1)).exist(eq("anything"));
  }
}
