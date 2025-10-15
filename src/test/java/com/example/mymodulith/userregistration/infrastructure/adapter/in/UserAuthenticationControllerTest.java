package com.example.mymodulith.userregistration.infrastructure.adapter.in;

import com.example.mymodulith.userregistration.application.port.in.RegisterUserPort;
import com.example.mymodulith.userregistration.application.port.in.UserInformations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@AutoConfigureMockMvc
class UserAuthenticationControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private RegisterUserPort registerUserPort;

  @Test
  void registerUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
          {
              "username": "testuser",
              "password": "password123",
              "email": "testuser@example.com",
              "firstName": "Test",
              "lastName": "User"
          }
          """))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andExpect(MockMvcResultMatchers.content().string("User registered successfully"));

    ArgumentCaptor<UserInformations> userInformationsArgumentCaptor = ArgumentCaptor.forClass(UserInformations.class);

    Mockito.verify(registerUserPort).register(userInformationsArgumentCaptor.capture());
    Assertions.assertEquals(
      new UserInformations("testuser", "password123", "testuser@example.com", "Test", "User"),
      userInformationsArgumentCaptor.getValue());
  }
}
