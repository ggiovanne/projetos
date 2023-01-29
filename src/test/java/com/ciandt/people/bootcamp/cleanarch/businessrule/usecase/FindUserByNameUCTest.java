package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindUserByName;
import com.ciandt.people.bootcamp.cleanarch.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The type Find user by name uc test.
 */
class FindUserByNameUCTest {
    private FindUserByNameUC uc;
    private final FindUserByName findUserByName = mock(FindUserByName.class);

    /**
     * Init.
     */
    @BeforeEach
    public void init() {
        this.uc = new FindUserByNameUC(findUserByName);
    }

    /**
     * Execute with null arguments will fail.
     */
    @Test
    void executeWithNullArgumentsWillFail() {
        final String name = null;

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> uc.execute(name),
                "Expected should throw an Exception"
        );

        assertTrue(thrown.getMessage().contains("Nome não pode estar vazio"));
    }

    /**
     * Execute wil valid name will successfully.
     */
    @Test
    void executeWithValidNameWillSuccessfully() {
        final String name = "Terezinha";
        final User user = User.builder()
                .name(name)
                .build();

        when(findUserByName.findByName(name)).thenReturn(Optional.of(user));

        User ucUser = uc.execute(name).get();

        assertNotNull(ucUser);
        assertEquals(name, ucUser.getName());
    }

    /**
     * Execute with invalid name will successfully.
     */
    @Test
    void executeWithInvalidNameWillSuccessfully() {
        final String name = "Terezinha";

        when(findUserByName.findByName(name)).thenReturn(Optional.empty());

        Optional<User> ucUser = uc.execute(name);

        assertTrue(ucUser.isEmpty());
    }
}