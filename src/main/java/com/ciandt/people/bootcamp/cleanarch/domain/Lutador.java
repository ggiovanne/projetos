package com.ciandt.people.bootcamp.cleanarch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lutador {
	private long id;
	private String nome;
	private String nacionalidade;
	private int idade;
	private double altura;
	private double peso;
	private int quantidadeVitorias;
	private int quantidadeDerrotas;
	private int quantidadeEmpates; 
	private double totalPremios;
}
