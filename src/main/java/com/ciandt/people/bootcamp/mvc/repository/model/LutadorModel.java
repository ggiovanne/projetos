package com.ciandt.people.bootcamp.mvc.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_LUTADORES")
public class LutadorModel {
	

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", unique = true)
    @NotEmpty(message = "nome cannot be empty")
    @NotNull(message = "nome cannot be null")
    private String nome;

    @Column(name = "nacionalidade")
    @NotEmpty(message = "nacionalidade cannot be empty")
    @NotNull(message = "nacionalidade cannot be null")
    private String nacionalidade;

    @Column(name = "idade")
    @NotEmpty(message = "idade cannot be empty")
    @NotNull(message = "idade cannot be null")
    private String idade;
    
    @Column(name = "altura")
    @NotEmpty(message = "altura cannot be empty")
    @NotNull(message = "altura cannot be null")
	private double altura;
	
    @Column(name = "peso")
    @NotEmpty(message = "peso cannot be empty")
    @NotNull(message = "peso cannot be null")
    private double peso;

    @Column(name = "quantidade_vitorias")
    @NotEmpty(message = "quantidadeVitorias cannot be empty")
    @NotNull(message = "quantidadeVitorias cannot be null")
	private int quantidadeVitorias;
    
    @Column(name = "quantidade_derrotas")
    @NotEmpty(message = "quantidadeDerrotas cannot be empty")
    @NotNull(message = "quantidadeDerrotas cannot be null")
	private int quantidadeDerrotas;
    
    @Column(name = "quantidade_empates")
    @NotEmpty(message = "quantidadeEmpates cannot be empty")
    @NotNull(message = "quantidadeEmpates cannot be null")
	private int quantidadeEmpates; 
    
    @Column(name = "total_premios")
    @NotEmpty(message = "totalPremios cannot be empty")
    @NotNull(message = "totalPremios cannot be null")
	private double totalPremios;	
}
