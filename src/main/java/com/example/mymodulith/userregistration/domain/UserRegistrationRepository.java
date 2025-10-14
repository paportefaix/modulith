package com.example.mymodulith.userregistration.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRegistrationRepository extends CrudRepository<UserEntity, String> {
}
