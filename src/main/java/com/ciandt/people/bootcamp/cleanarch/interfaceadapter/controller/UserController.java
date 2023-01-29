package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller;

import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindUserByNameUC;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.UserNotFoundException;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model.GetUserResponse;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model.GetUserResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserController {
    private final FindUserByNameUC findUserByNameUC;

    public GetUserResponse getByName(final String name) {
        log.info("getByName with name: {}", name);
        return GetUserResponseMapper.INSTANCE.entityToResponse(Optional.of(findUserByNameUC.execute(name)).get()
                .orElseThrow(UserNotFoundException::new));
    }
}
