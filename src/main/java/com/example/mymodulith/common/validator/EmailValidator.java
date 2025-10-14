package com.example.mymodulith.common.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator {

  private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
  private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

  public boolean validateEmail(String email) {
    if (email == null) {
      return false;
    }
    return pattern.matcher(email).matches();
  }
}
