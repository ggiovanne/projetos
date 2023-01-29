package com.ciandt.people.bootcamp.mvc.controller;

import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClient;
import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClientMapper;
import com.ciandt.people.bootcamp.mvc.entity.Lutador;
import com.ciandt.people.bootcamp.mvc.service.LutaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RestController
@RequestMapping(value = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LutaController {

    @Autowired
    private LutaService lutaService;

    @GetMapping(path = "/lutadores")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<LutadorClient>> all() {
        log.info("getAll Lutadores");
        Optional<List<Lutador>> lutadoresOptional = lutaService.findAll();
        if (lutadoresOptional.isPresent()) {
            return Optional.ofNullable(LutadorClientMapper.INSTANCE.entityToClient(lutadoresOptional.get()));
        } else {
            return Optional.empty();
        }

    }
    @GetMapping(path = "/lutadores/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String getByNome (@PathVariable String nome) {
       	return "O nome informado na API foi: " + nome;
       } 


    @GetMapping(path = "/lutadores/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<LutadorClient> getById(@PathVariable Long id) {
        log.info("getById with id: {}", id);
        Optional<Lutador> lutadorModelOptional = lutaService.findByID(id);
        if (lutadorModelOptional.isPresent()) {
            Lutador lutadorModel = lutadorModelOptional.get();
            return Optional.ofNullable(LutadorClientMapper.INSTANCE.entityToClient(lutadorModel));
        } else {
            return Optional.empty();
        }
    }
    
    
    @GetMapping (path = "/lutadores/faixaIdade/{idade1}/{idade2}")
    @ResponseStatus (HttpStatus.OK)
    public Optional<List<LutadorClient>> getByIdade (@PathVariable Long idade1, @PathVariable Long idade2) {
        Optional<List<Lutador>> lutadorModelOptional = lutaService.findByIdade(idade1,idade2);
        if (lutadorModelOptional.isPresent()) {
           List<Lutador> lutadorModel = lutadorModelOptional.get();
            return Optional.ofNullable(LutadorClientMapper.INSTANCE.entityToClient(lutadorModel));
        } else {
            return Optional.empty();
        }
        
    }

    @PostMapping(path = "/lutadores",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<LutadorClient> create(@RequestBody LutadorClient lutadorClient) {
        Optional<Lutador> lutadorOptional = lutaService.adicionarLutador(lutadorClient);
        if (lutadorOptional.isPresent()) {
            return Optional.ofNullable(LutadorClientMapper.INSTANCE.entityToClient(lutadorOptional.get()));
        } else {
            return Optional.empty();
        }


    }

    @PutMapping(path = "/lutadores",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LutadorClient update(@RequestBody LutadorClient lutadorClient) {
        return null;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("handling illegal argument exception with message: {}", ex.getMessage());

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public LutaController(LutaService lutaService) {
        this.lutaService = lutaService;
    }
}
