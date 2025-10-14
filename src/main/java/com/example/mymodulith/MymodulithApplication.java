package com.example.mymodulith;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Slf4j
@SpringBootApplication
@Modulithic
public class MymodulithApplication {

  static void main(String[] args) {
    SpringApplication.run(MymodulithApplication.class, args);
  }

}
