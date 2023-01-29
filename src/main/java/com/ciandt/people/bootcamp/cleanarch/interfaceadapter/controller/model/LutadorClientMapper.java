package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model;

import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LutadorClientMapper {
    LutadorClientMapper INSTANCE = Mappers.getMapper(LutadorClientMapper.class);

    @Mapping(source = "quantidadeVitorias", target = "vitorias")
    @Mapping(source = "quantidadeEmpates", target = "empates")
    @Mapping(source = "quantidadeDerrotas", target = "derrotas")
    @Mapping(source = "totalPremios", target = "premios")
    LutadorClient entityToClient(Lutador entity);

    @Mapping(source = "vitorias", target = "quantidadeVitorias")
    @Mapping(source = "empates", target = "quantidadeEmpates")
    @Mapping(source = "derrotas", target = "quantidadeDerrotas")
    @Mapping(source = "premios", target = "totalPremios")
    Lutador clientToEntity(LutadorClient lutadorClient);

    List<LutadorClient> entityToClient(List<Lutador> entity);
}
