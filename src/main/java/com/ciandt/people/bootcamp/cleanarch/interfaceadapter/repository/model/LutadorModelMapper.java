package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.repository.model;

import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;


import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LutadorModelMapper {
    LutadorModelMapper INSTANCE = Mappers.getMapper(LutadorModelMapper.class);

    Lutador modelToEntity(LutadorModel model);

    LutadorModel entityToModel(Lutador lutador);

    List<Lutador> modelToEntity(List<LutadorModel> lutadorModelList);

}
