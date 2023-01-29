package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.repository.model;

import com.ciandt.people.bootcamp.cleanarch.domain.User;
import com.ciandt.people.bootcamp.mvc.repository.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    User modelToEntity(UserModel model);
}
