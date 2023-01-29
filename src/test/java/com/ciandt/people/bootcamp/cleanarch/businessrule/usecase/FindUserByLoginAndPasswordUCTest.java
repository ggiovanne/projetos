package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByLoginAndPassword;
import com.ciandt.people.bootcamp.cleanarch.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindUserByLoginAndPasswordUCTest {
    private FindUserByLoginAndPasswordUC uc;
    private final FindUserByLoginAndPassword findUserByLoginAndPassword = mock(FindUserByLoginAndPassword.class);

    /**
     * Init.
     */
    @BeforeEach
    public void init() {
        this.uc = new FindUserByLoginAndPasswordUC(findUserByLoginAndPassword);
    }

    /**
     * Execute with null arguments will fail.
     */
    @Test
    void executeWithNullArgumentsWillFail() {
        final String login = null;
        final String password = "123";

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> uc.execute(login, password),
                "Expected should throw an Exception"
        );

        assertTrue(thrown.getMessage().contains("Login não pode estar vazio"));
    }

    /**
     * Execute wil valid login will successfully.
     */
    @Test
    void executeWithValidLoginWillSuccessfully() {
        final String login = "terezinha";
        final String password = "123";

        final User user = User.builder()
                .login(login)
                .build();

        when(findUserByLoginAndPassword.findByLoginAndPassword(login, password)).thenReturn(Optional.of(user));

        User ucUser = uc.execute(login, password).get();

        assertNotNull(ucUser);
        assertEquals(login, ucUser.getLogin());
    }

    /**
     * Execute with invalid login will successfully.
     */
    @Test
    void executeWithInvalidLoginWillSuccessfully() {
        final String login = "terezinha";
        final String password = "123";

        when(findUserByLoginAndPassword.findByLoginAndPassword(login, password)).thenReturn(Optional.empty());

        Optional<User> ucUser = uc.execute(login, password);

        assertTrue(ucUser.isEmpty());
    }
}