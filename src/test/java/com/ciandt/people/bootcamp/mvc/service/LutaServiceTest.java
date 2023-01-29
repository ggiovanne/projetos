package com.ciandt.people.bootcamp.mvc.service;

import com.ciandt.people.bootcamp.cleanarch.domain.exception.LutadorNotFoundException;
import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClient;
import com.ciandt.people.bootcamp.mvc.entity.Lutador;
import com.ciandt.people.bootcamp.mvc.repository.LutadorRepository;
import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LutaServiceTest {
	private LutaService lutaService;
	private final LutadorRepository lutadorRepository = mock(LutadorRepository.class);

	@BeforeEach
	public void init() {
		this.lutaService = new LutaService(lutadorRepository);
	}

	@Test
	void executeFindByIdWithValidIdWithAExistingLutadorWillSuccessfully() {
		final Long id = Long.valueOf(1);
		String nome = "Street Fighter";

		when(lutadorRepository.findById(id)).thenReturn(Optional.ofNullable(LutadorModel.builder().nome(nome).build()));

		Optional<Lutador> lutador = lutaService.findByID(id);

		assertTrue(lutador.isPresent());
		assertEquals(nome, lutador.get().getNome());
	}

	@Test
	void executeFindByIdWithValidIdWithANonExistingUserWillSuccessfully() {
		final Long id = Long.valueOf(456);

		when(lutadorRepository.findById(id)).thenReturn(Optional.empty());

		LutadorNotFoundException thrown = assertThrows(LutadorNotFoundException.class, () -> lutaService.findByID(id),
				"Expected should throw an Exception");
		assertNotNull(thrown.getMessage());
	}

	@Test
	void executeFindByIdWithNullArgumentsWillFail() {
		final Long id = null;

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> lutaService.findByID(id),
				"Expected should throw an Exception");

		assertTrue(thrown.getMessage().contains("ID não pode estar vazio"));
	}

	@Test
	void vericandoUmLutadorNulo() {
		LutadorClient lutadorTeste = null;

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> lutaService.adicionarLutador(lutadorTeste), "Expected should throw an Exception");

		assertTrue(thrown.getMessage().contains("Lutador não pode estar vazio"));

	}

	@Test
	public void executarFindAllComSucesso() {

		ArrayList<LutadorModel> todosLutadores = new ArrayList<LutadorModel>();
		LutadorModel lutadorJaqueline = new LutadorModel();
		lutadorJaqueline.setId(Long.valueOf(2));
		lutadorJaqueline.setNome("Jaqueline");
		todosLutadores.add(lutadorJaqueline);
		LutadorModel lutadorExtends = new LutadorModel();
		lutadorExtends.setId(Long.valueOf(3));
		lutadorExtends.setNome("Gabriel");
		todosLutadores.add(lutadorExtends);
		when(lutadorRepository.findAll()).thenReturn(todosLutadores);

		Optional<List<Lutador>> listLutadoresRetornados = lutaService.findAll();
		assertTrue(listLutadoresRetornados.isPresent());
		assertTrue(listLutadoresRetornados.get().size() == 2);
		for (LutadorModel lutadorModel : todosLutadores) {
			if (lutadorModel.getId() == 2) {
				assertTrue(lutadorModel.getNome().equals("Jaqueline"), "Lutador de id 2 deve se chamar Jaqueline");

			}
		}
	}

}