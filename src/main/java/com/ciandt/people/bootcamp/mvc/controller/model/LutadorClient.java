package com.ciandt.people.bootcamp.mvc.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LutadorClient {
    private int id;
    private String nome;
    private String nacionalidade;
    private int idade;
    private double altura;
    private double peso;
    private int vitorias;
    private int derrotas;
    private int empates;
    private double premios;
}
