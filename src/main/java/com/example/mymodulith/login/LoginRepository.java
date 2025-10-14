package com.example.mymodulith.login;

import org.springframework.data.repository.CrudRepository;

interface LoginRepository extends CrudRepository<LoginEntity,String> {
}
