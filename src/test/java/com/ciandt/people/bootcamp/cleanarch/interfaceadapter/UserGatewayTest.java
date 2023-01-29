package com.ciandt.people.bootcamp.cleanarch.interfaceadapter;

import com.ciandt.people.bootcamp.cleanarch.domain.User;
import com.ciandt.people.bootcamp.mvc.repository.UserRepository;
import com.ciandt.people.bootcamp.mvc.repository.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserGatewayTest {
    private UserGateway gw;
    private final UserRepository userRepository = mock(UserRepository.class);

    @BeforeEach
    public void init() {
        this.gw = new UserGateway(userRepository);
    }

    @Test
    void executeFindByNameWithValidNameWithAExistingUserWillSuccessfully() {
        final String name = "Ben Parvar";

        when(userRepository.findByName(name)).thenReturn(UserModel.builder().name(name).build());

        Optional<User> user = gw.findByName(name);

        assertTrue(user.isPresent());
        assertEquals(name, user.get().getName());
    }

    @Test
    void executeFindByNameWithValidNameWithANonExistingUserWillSuccessfully() {
        final String name = "Ben Parvar";

        when(userRepository.findByName(name)).thenReturn(null);

        Optional<User> user = gw.findByName(name);

        assertFalse(user.isPresent());
    }

    @Test
    void executeFindByLoginWithValidLoginPasswordWithAExistingUserWillSuccessfully() {
        final String login = "benparvar";
        final String password = "123";

        when(userRepository.findByLoginAndPassword(login, password)).thenReturn(UserModel.builder().login(login).build());

        Optional<User> user = gw.findByLoginAndPassword(login, password);

        assertTrue(user.isPresent());
        assertEquals(login, user.get().getLogin());
    }

    @Test
    void executeFindByLoginWithValidLoginPasswordWithANonExistingUserWillSuccessfully() {
        final String login = "benparvar";
        final String password = "123";

        when(userRepository.findByLoginAndPassword(login, password)).thenReturn(null);

        Optional<User> user = gw.findByLoginAndPassword(login, password);

        assertFalse(user.isPresent());
    }
}