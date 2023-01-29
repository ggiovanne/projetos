package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindLutadorById;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * É uma classe de exemplo
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class FindLutadorByIdUC {
    public static final String ID_CAN_NOT_BE_NULL = "ID não pode estar vazio";
    private final FindLutadorById findLutadorById;

    public Optional<Lutador> execute(final Long id) {
        if (null == id) {
            log.error(ID_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(ID_CAN_NOT_BE_NULL);
        }
        return findLutadorById.findById(id);
    }
}
