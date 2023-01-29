package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model;

import com.ciandt.people.bootcamp.cleanarch.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetUserResponseMapper {
    GetUserResponseMapper INSTANCE = Mappers.getMapper(GetUserResponseMapper.class);

    @Mapping(source = "login", target = "userName")
    GetUserResponse entityToResponse(User entity);
}
