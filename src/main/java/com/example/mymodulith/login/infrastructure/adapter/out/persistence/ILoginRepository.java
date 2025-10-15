package com.example.mymodulith.login.infrastructure.adapter.out.persistence;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ILoginRepository extends CrudRepository<LoginEntity, String> {
}
