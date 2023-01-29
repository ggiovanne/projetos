package com.ciandt.people.bootcamp.cleanarch.businessrule.usecase;

import com.ciandt.people.bootcamp.cleanarch.businessrule.FindAllLutadores;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindAllLutadoresUC {
    private final FindAllLutadores findAllLutadores;

    public List<Lutador> execute() {
        return findAllLutadores.findAll();
    }
}
