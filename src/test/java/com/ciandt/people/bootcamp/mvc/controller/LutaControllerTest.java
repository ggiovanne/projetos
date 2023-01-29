package com.ciandt.people.bootcamp.mvc.controller;

import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClient;
import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClientMapper;
import com.ciandt.people.bootcamp.mvc.entity.Lutador;
import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.LutadorNotFoundException;
import com.ciandt.people.bootcamp.mvc.service.LutaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.AssertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LutaControllerTest {
	private LutaController controller;
	private final LutaService lutaService = mock(LutaService.class);

	@BeforeEach
	public void init() {
		this.controller = new LutaController(lutaService);
	}

	@Test
	@DisplayName("Esse metodos faz um teste com id nulo e o resultado esperado é uma exceção ilegal argument")
	void executeGetByIdWithNullArgumentsWillFail() {
		final Long id = null;

		when(lutaService.findByID(id)).thenThrow(new IllegalArgumentException("Id não pode estar vazio"));

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> controller.getById(id),
				"Expected should throw an Exception");

		assertTrue(thrown.getMessage().contains("Id não pode estar vazio"));
	}

	@Test
	void executarCreatedComLutadorNulo() {
		// Lutador lutadorNull = null;
		LutadorClient lutadorClientNull = null;
		when(lutaService.adicionarLutador(lutadorClientNull))
				.thenThrow(new IllegalArgumentException("Lutador está vazio"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> controller.create(lutadorClientNull), "Expected should throw an Exception");

		assertTrue(thrown.getMessage().contains("Lutador está vazio"));

	}

	@Test
	@DisplayName("Create lutador e verificando se esta recebendo o mesmo objeto recebido")
	void deveriacriarUmLutador() {
		LutadorClient lutador = new LutadorClient(0, "Eliel", "Brasil", 35, 1.85, 80, 20, 4, 10, 5500000);
		Lutador novoLutador = new Lutador();
		novoLutador.setId(48);
		novoLutador.setIdade(35);
		novoLutador.setNome("Eliel");
		novoLutador.setNacionalidade("Brasil");
		novoLutador.setAltura(1.85);
		novoLutador.setQuantidadeDerrotas(4);
		novoLutador.setQuantidadeEmpates(10);
		novoLutador.setQuantidadeVitorias(20);
		novoLutador.setTotalPremios(5500000);
		when(lutaService.adicionarLutador(lutador))
				.thenReturn(Optional.ofNullable(novoLutador));
		Optional<LutadorClient> lutadorCanseira = controller.create(lutador);
		LutadorClient lutadorTeste = lutadorCanseira.get();
		assertTrue(lutadorCanseira.isPresent());
		assertNotNull(lutadorTeste);
		assertTrue(lutadorTeste.getId() == 48);
		assertTrue(lutadorTeste.getNacionalidade() == "Brasil");
		assertTrue(lutadorTeste.getIdade() == 35);

	}

	@Test
	void executeGetByIdWithValidArgumentsButNotFoundLutadorWillFail() {
		final Long id = Long.valueOf(666);

		when(lutaService.findByID(id)).thenThrow(new LutadorNotFoundException(Long.valueOf(666)));

		LutadorNotFoundException thrown = assertThrows(LutadorNotFoundException.class, () -> controller.getById(id),
				"Expected should throw an Exception");

		assertNotNull(thrown.getMessage());
	}

	/**
	 * Execute wil valid name will successfully.
	 */
	@Test
	void executeGetByIdWithValidIdWillSuccessfully() {
		final Long id = Long.valueOf(1);
		final Lutador lutador = Lutador.builder().id(id).nome("Mike Tyson").build();

		when(lutaService.findByID(id)).thenReturn(Optional.ofNullable(lutador));

		LutadorClient ucLutadorClient = controller.getById(id).get();

		assertNotNull(ucLutadorClient);
		assertEquals(id, ucLutadorClient.getId());
	}

	@Test
	void deveriaBuscarTodosOsLutadores() {
		Optional<List<Lutador>> lutadores = lutadores();
		when(lutaService.findAll()).thenReturn(lutadores);
		Optional<List<LutadorClient>> listaRetornadaController = controller.all();
		
		assertTrue(listaRetornadaController.isPresent());
		assertTrue(listaRetornadaController.get().size() == 3);

	}

	@Test
	void executeFindByIdadeWithValidIdadeWithAExistingLutadorWillSuccessfully() {
		final Long idade1 = Long.valueOf(35);
		final Long idade2 = Long.valueOf(40);
		// Optional<List<Lutador>>lutadores = lutadores();

		when(lutaService.findByIdade(idade1, idade2)).thenReturn(lutadores());

		Optional<List<LutadorClient>> lutadores = controller.getByIdade(idade1, idade2);

		assertTrue(lutadores.isPresent());

	}

	Optional<List<Lutador>> lutadores() {
		ArrayList lutadores = new ArrayList();
		Lutador lutador1 = new Lutador();
		lutador1.setNome("jonas");
		lutador1.setIdade(35);
		lutador1.setAltura(1.70);
		lutador1.setNacionalidade("brasil");
		lutador1.setPeso(200);
		lutador1.setQuantidadeVitorias(2);
		lutador1.setQuantidadeDerrotas(3);
		lutador1.setQuantidadeEmpates(5);
		lutador1.setTotalPremios(2000);
		Lutador lutador2 = new Lutador();
		lutador2.setIdade(28);
		lutador2.setNome("lucas");
		lutador2.setAltura(1.70);
		lutador2.setNacionalidade("brasil");
		lutador2.setPeso(200);
		lutador2.setQuantidadeVitorias(2);
		lutador2.setQuantidadeDerrotas(3);
		lutador2.setQuantidadeEmpates(5);
		lutador2.setTotalPremios(2000);
		Lutador lutador3 = new Lutador();
		lutador3.setNome(" Pedro");
		lutador3.setIdade(40);
		lutador3.setAltura(1.70);
		lutador3.setNacionalidade("brasil");
		lutador3.setPeso(200);
		lutador3.setQuantidadeVitorias(2);
		lutador3.setQuantidadeDerrotas(3);
		lutador3.setQuantidadeEmpates(5);
		lutador3.setTotalPremios(2000);
		lutadores.add(lutador1);
		lutadores.add(lutador2);
		lutadores.add(lutador3);

		return Optional.of(lutadores);
	}

}