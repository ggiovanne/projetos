package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.UpdateLutador;
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
public class UpdateLutadorUC {
    private final UpdateLutador updateLutador;

    public Lutador execute(Lutador lutador) {
        return updateLutador.update(lutador);
    }
}
