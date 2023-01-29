package com.ciandt.people.bootcamp.cleanarch.businessrule;

import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;

import java.util.Optional;

public interface FindLutadorById {

    Optional<Lutador> findById(Long id);
}
