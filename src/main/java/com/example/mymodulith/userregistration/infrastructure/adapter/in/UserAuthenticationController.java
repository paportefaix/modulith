package com.example.mymodulith.userregistration.infrastructure.adapter.in;

import com.example.mymodulith.userregistration.application.port.in.RegisterUserPort;
import com.example.mymodulith.userregistration.application.port.in.UserInformations;
import com.example.mymodulith.userregistration.application.port.in.VerifyUserPort;
import lombok.AllArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@PrimaryAdapter
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
class UserAuthenticationController {

  private final RegisterUserPort registerUserPort;
  private final VerifyUserPort verifyUserPort;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
    registerUserPort.register(new UserInformations(userDto.username(), userDto.password(), userDto.email(), userDto.firstName(), userDto.lastName()));
    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
  }

  @PostMapping("/verify/{userName}")
  public ResponseEntity<Boolean> verifyUser(@PathVariable String userName) {
    boolean verify = verifyUserPort.verifyUser(userName);
    return new ResponseEntity<>(verify, HttpStatus.OK);
  }
}
