package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindLutadorById;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The type Find user by name uc test.
 */
class FindLutadorByIdUCTest {
    private FindLutadorByIdUC uc;
    private final FindLutadorById findLutadorById = mock(FindLutadorById.class);

    /**
     * Init.
     */
    @BeforeEach
    public void init() {
        this.uc = new FindLutadorByIdUC(findLutadorById);
    }

    /**
     * Execute with null arguments will fail.
     */
    @Test
    void executeWithNullArgumentsWillFail() {
        final Long id = null;

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> uc.execute(id),
                "Expected should throw an Exception"
        );

        assertTrue(thrown.getMessage().contains("ID não pode estar vazio"));
    }

    /**
     * Execute wil valid name will successfully.
     */
    @Test
    void executeWithValidIdWillSuccessfully() {
        final Long id = Long.valueOf(1);
        final Lutador lutador = Lutador.builder()
                .id(id)
                .build();

        when(findLutadorById.findById(id)).thenReturn(Optional.of(lutador));

        Lutador ucLutador = uc.execute(id).get();

        assertNotNull(ucLutador);
        assertEquals(id, ucLutador.getId());
    }

    /**
     * Execute with invalid name will successfully.
     */
    @Test
    void executeWithInvalidNameWillSuccessfully() {
        final Long id = Long.valueOf(0);

        when(findLutadorById.findById(id)).thenReturn(Optional.empty());

        Optional<Lutador> ucUser = uc.execute(id);

        assertTrue(ucUser.isEmpty());
    }
}