package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByName;
import com.ciandt.people.bootcamp.cleanarch.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * É uma classe de exemplo
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class FindUserByNameUC {
    public static final String NAME_CAN_NOT_BE_NULL = "Nome não pode estar vazio";
    private final FindUserByName findUserByName;

    public Optional<User> execute(final String name) {
        if (null == name) {
            log.error(NAME_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(NAME_CAN_NOT_BE_NULL);
        }
        return findUserByName.findByName(name);
    }
}
