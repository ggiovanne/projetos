package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller;

import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.AddLutadorUC;
import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindAllLutadoresUC;
import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindLutadorByIdUC;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.LutadorNotFoundException;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class LutadorController {
    private final FindAllLutadoresUC findAllLutadoresUC;
    private final AddLutadorUC addLutadorUC;
    private final FindLutadorByIdUC findLutadorByIdUC;

    public List<LutadorClient> all() {
        log.info("getAll Lutadores");
        return LutadorClientMapper.INSTANCE.entityToClient(findAllLutadoresUC.execute());
    }

    public LutadorClient getById(final Long id) {
        log.info("getById with id: {}", id);

        return LutadorClientMapper.INSTANCE.entityToClient(Optional.of(findLutadorByIdUC.execute(id)).get()
                .orElseThrow(() -> new LutadorNotFoundException(id)));
    }

    public LutadorClient create(LutadorClient lutadorClient) {
        return LutadorClientMapper.INSTANCE.entityToClient(addLutadorUC.execute(LutadorClientMapper.INSTANCE.clientToEntity(lutadorClient)));
    }
}
