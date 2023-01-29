package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByLoginAndPassword;
import com.ciandt.people.bootcamp.cleanarch.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindUserByLoginAndPasswordUC {
    public static final String LOGIN_CAN_NOT_BE_NULL = "Login não pode estar vazio";
    private final FindUserByLoginAndPassword findUserByLoginAndPassword;

    public Optional<User> execute(final String login, final String password) {
        if (null == login) {
            log.error(LOGIN_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(LOGIN_CAN_NOT_BE_NULL);
        }
        return findUserByLoginAndPassword.findByLoginAndPassword(login, password);
    }
}
