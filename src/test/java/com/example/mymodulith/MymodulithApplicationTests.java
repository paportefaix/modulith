package com.example.mymodulith;

import com.example.mymodulith.common.configuration.ApiError;
import com.example.mymodulith.userregistration.infrastructure.adapter.in.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MymodulithApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void contextLoads() {
  }


  @Test
  void testExceptionHandler() throws Exception {
    var userDto = new UserDto("username", "password", "not_an_email", "firstName", "lastName");

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
        .contentType(MediaType.APPLICATION_JSON).content(toJson(userDto)))
      .andDo(print())
      .andExpectAll(status().isBadRequest())
      .andReturn();

    ApiError apiError = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ApiError.class);

    Assertions.assertEquals("Field validation failed", apiError.message());

    apiError.errors().forEach((field, message) -> {
      Assertions.assertEquals("email", field);
      Assertions.assertEquals("must be a well-formed email address", message);
    });


  }

  private String toJson(Object obj) throws JsonProcessingException {
    return objectMapper.writeValueAsString(obj);
  }

}
