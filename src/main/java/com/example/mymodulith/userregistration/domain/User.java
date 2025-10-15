package com.example.mymodulith.userregistration.domain;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.regex.Pattern;

public class User {

  @Getter
  private final String username;
  @Getter
  private final String firstName;
  @Getter
  private final String lastName;
  @Getter
  private final String email;
  private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
  private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

  private User(String username, String firstName, String lastName, String email) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @SneakyThrows
  public static User create(String username, String firstName, String lastName, String email) {
    if (!validateEmail(email)) {
      throw new Exception("Email not valid");
    }
    return new User(username, firstName, lastName, email);
  }


  private static boolean validateEmail(String email) {
    if (email == null) {
      return false;
    }
    return pattern.matcher(email).matches();
  }
}
