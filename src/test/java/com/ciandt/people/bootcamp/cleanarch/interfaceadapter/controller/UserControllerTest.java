package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller;

import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindUserByNameUC;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {
    private UserController controller;
    private final FindUserByNameUC findUserByNameUC = mock(FindUserByNameUC.class);

    @BeforeEach
    public void init() {
        this.controller = new UserController(findUserByNameUC);
    }

    @Test
    void executeWithNullArgumentsWillFail() {
        final String name = null;

        when(findUserByNameUC.execute(name)).thenThrow(new IllegalArgumentException("Nome não pode estar vazio"));

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> controller.getByName(name),
                "Expected should throw an Exception"
        );

        assertTrue(thrown.getMessage().contains("Nome não pode estar vazio"));
    }

    @Test
    void executeWithValidArgumentsButNotFoundUserWillFail() {
        final String name = "Iron Maiden";

        when(findUserByNameUC.execute(name)).thenReturn(Optional.empty());

        UserNotFoundException thrown = assertThrows(
                UserNotFoundException.class,
                () -> controller.getByName(name),
                "Expected should throw an Exception"
        );

        assertNull(thrown.getMessage());
    }
}