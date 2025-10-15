package com.example.mymodulith.userregistration.infrastructure.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRegistrationRepository extends CrudRepository<UserEntity, String> {
}
