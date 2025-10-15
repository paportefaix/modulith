package com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@org.jmolecules.ddd.annotation.Entity
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @Id
  private String username;
  private String firstName;
  private String lastName;
  private String email;

}
