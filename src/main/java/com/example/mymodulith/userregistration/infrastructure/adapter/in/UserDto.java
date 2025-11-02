package com.example.mymodulith.userregistration.infrastructure.adapter.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDto(@NotEmpty String username, @NotEmpty String password, @Email String email, String firstName, String lastName) {

}
