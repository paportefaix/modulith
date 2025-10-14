package com.example.mymodulith.login;

import com.example.mymodulith.login.controller.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.NamedInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NamedInterface("LoginService")
@Service
public class LoginService {


  LoginRepository loginRepository;

  LoginService(@Autowired LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  public void saveLogin(LoginDto loginDTO1) {
    LoginEntity loginEntity = new LoginEntity();
    loginEntity.setUsername(loginDTO1.username());
    loginEntity.setPassword(loginDTO1.password());
    loginRepository.save(loginEntity);

  }

  public boolean login(LoginDto loginDTO) {

    Optional<LoginEntity> loginEntity = loginRepository.findById(loginDTO.username());
    if (loginEntity.isPresent()) {
      LoginEntity loginEntity1 = loginEntity.get();
      return loginEntity1.getPassword().equals(loginDTO.password());
    }

    return false;
  }
}
