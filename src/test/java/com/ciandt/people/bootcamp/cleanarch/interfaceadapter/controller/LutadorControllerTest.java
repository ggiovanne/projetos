package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller;

import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.AddLutadorUC;
import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindAllLutadoresUC;
import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindLutadorByIdUC;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.LutadorNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LutadorControllerTest {
    private LutadorController controller;

    private final FindAllLutadoresUC findAllLutadoresUC = mock(FindAllLutadoresUC.class);
    private final AddLutadorUC addLutadorUC = mock(AddLutadorUC.class);
    private final FindLutadorByIdUC findLutadorByIdUC = mock(FindLutadorByIdUC.class);

    @BeforeEach
    public void init() {
        this.controller = new LutadorController(findAllLutadoresUC, addLutadorUC, findLutadorByIdUC);
    }

    @Test
    void executeGetByIdWithNullArgumentsWillFail() {
        final Long id = null;

        when(findLutadorByIdUC.execute(id)).thenThrow(new IllegalArgumentException("Id não pode estar vazio"));

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> controller.getById(id),
                "Expected should throw an Exception"
        );

        assertTrue(thrown.getMessage().contains("Id não pode estar vazio"));
    }

    @Test
    void executeGetByIdWithValidArgumentsButNotFoundLutadorWillFail() {
        final Long id = Long.valueOf(666);

        when(findLutadorByIdUC.execute(id)).thenReturn(Optional.empty());

        LutadorNotFoundException thrown = assertThrows(
                LutadorNotFoundException.class,
                () -> controller.getById(id),
                "Expected should throw an Exception"
        );

        assertNotNull(thrown.getMessage());
    }

    /**
     * Execute wil valid name will successfully.
     */
    @Test
    void executeGetByIdWithValidIdWillSuccessfully() {
        final Long id = Long.valueOf(1);
        final Lutador lutador = Lutador.builder()
                .id(id).nome("Mike Tyson")
                .build();

        when(findLutadorByIdUC.execute(id)).thenReturn(Optional.of(lutador));

        Lutador ucLutador = findLutadorByIdUC.execute(id).get();

        assertNotNull(ucLutador);
        assertEquals(id, ucLutador.getId());
    }

}