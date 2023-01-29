package com.ciandt.people.bootcamp.cleanarch.interfaceadapter;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByLoginAndPassword;
import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByName;
import com.ciandt.people.bootcamp.cleanarch.domain.User;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.repository.model.UserModelMapper;
import com.ciandt.people.bootcamp.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserGateway implements FindUserByName, FindUserByLoginAndPassword {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(UserModelMapper.INSTANCE.modelToEntity(userRepository.findByName(name)));
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return Optional.ofNullable(UserModelMapper.INSTANCE.modelToEntity(userRepository.findByLoginAndPassword(login, password)));
    }
}
