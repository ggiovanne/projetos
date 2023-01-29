package com.ciandt.people.bootcamp.mvc.repository;

import com.ciandt.people.bootcamp.mvc.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByName(String name);

    UserModel findByLoginAndPassword(String login, String password);
}
