package com.example.mymodulith.login.infrastructure.adapter.in;

import com.example.mymodulith.login.application.port.in.AuthenticateUserPort;
import com.example.mymodulith.login.application.port.in.Login;
import lombok.AllArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@PrimaryAdapter
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
class LoginController {

  private AuthenticateUserPort loginUser;

  @PostMapping("/login")
  ResponseEntity<String> login(@RequestBody LoginDto loginDTO) throws Exception {
    boolean isLogged = loginUser.authenticate(new Login(loginDTO.username(), loginDTO.password()));
    if (isLogged)
      return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @GetMapping("/login")
  ResponseEntity<String> getTest() {
    return new ResponseEntity<>("Login test Successful", HttpStatus.OK);
  }
}
