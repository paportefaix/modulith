package com.example.mymodulith.login.controller;

import com.example.mymodulith.login.LoginService;
import com.example.mymodulith.login.controller.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
class LoginController {

  @Autowired
  LoginService loginService;

  @PostMapping("/login")
  ResponseEntity<String> registerUser(@RequestBody LoginDto loginDTO) {
    boolean login = loginService.login(loginDTO);
    if (login)
      return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @GetMapping("/login")
  ResponseEntity<String> getTest(){
    return new ResponseEntity<>("Login test Successful", HttpStatus.OK);
  }
}
