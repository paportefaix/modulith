package com.example.mymodulith.login.infrastructure.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface ILoginRepository extends CrudRepository<LoginEntity, String> {
}
