package com.example.mymodulith.login.infrastructure.adapter.out.persistence.service;

import com.example.mymodulith.login.application.port.out.LoginServicePort;
import com.example.mymodulith.login.domain.LoginAggregate;
import com.example.mymodulith.login.infrastructure.adapter.out.persistence.ILoginRepository;
import com.example.mymodulith.login.infrastructure.adapter.out.persistence.LoginEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Service;

@SecondaryAdapter
@Slf4j
@Service
@AllArgsConstructor
public class DomainLoginServicePort implements LoginServicePort {

  public ILoginRepository iLoginRepository;

  public LoginAggregate loadLogin(String username) throws Exception {
    var userLogin = iLoginRepository.findById(username).orElse(null);
    return LoginAggregate.load(userLogin);
  }

  @Override
  public void save(LoginAggregate loginAggregate) {
    var loginEntity = new LoginEntity();
    loginEntity.setPassword(loginAggregate.getPassword());
    loginEntity.setUsername(loginAggregate.getUsername());
    iLoginRepository.save(loginEntity);
  }
}
