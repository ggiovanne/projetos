package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.AddLutador;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * É uma classe de exemplo
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class AddLutadorUC {
    public static final String LUTADOR_CAN_NOT_BE_NULL = "Lutador não pode estar vazio";
    private final AddLutador addLutador;

    public Lutador execute(Lutador lutador) {
        if (null == lutador) {
            log.error(LUTADOR_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(LUTADOR_CAN_NOT_BE_NULL);
        }
        return addLutador.AddLutador(lutador);
    }
}
