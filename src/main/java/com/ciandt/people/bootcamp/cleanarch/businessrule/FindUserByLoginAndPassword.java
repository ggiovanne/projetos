package com.ciandt.people.bootcamp.cleanarch.businessrule;

import com.ciandt.people.bootcamp.cleanarch.domain.User;

import java.util.Optional;

public interface FindUserByLoginAndPassword {

    Optional<User> findByLoginAndPassword(String login, String password);
}
