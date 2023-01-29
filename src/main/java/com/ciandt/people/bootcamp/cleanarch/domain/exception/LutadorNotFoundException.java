package com.ciandt.people.bootcamp.cleanarch.domain.exception;

public class LutadorNotFoundException extends RuntimeException {

    public LutadorNotFoundException(Long id) {
        super("Não foi possível achar o lutador com id: " + id);
    }
    
    public LutadorNotFoundException(Long idade1, Long idade2) {
        super("Não foi possível achar um lutador entre as idades " + idade1 + " e " + idade2);
    }
}
