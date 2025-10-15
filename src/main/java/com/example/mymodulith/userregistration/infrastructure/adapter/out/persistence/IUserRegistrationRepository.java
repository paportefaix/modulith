package com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IUserRegistrationRepository extends CrudRepository<UserEntity, String> {
}
