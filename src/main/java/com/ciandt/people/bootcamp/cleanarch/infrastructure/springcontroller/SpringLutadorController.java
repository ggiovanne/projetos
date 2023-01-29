package com.ciandt.people.bootcamp.cleanarch.infrastructure.springcontroller;

import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.LutadorController;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model.LutadorClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v2/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringLutadorController {
    private final LutadorController lutadorController;

    @GetMapping(path = "/lutadores")
    @ResponseStatus(HttpStatus.OK)
    public List<LutadorClient> all() {
        log.info("getAll Lutadores");
        return lutadorController.all();
    }

    @GetMapping(path = "/lutadores/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LutadorClient getById(@PathVariable Long id) {
        log.info("getById with id: {}", id);

        return lutadorController.getById(id);
    }

    @PostMapping(path = "/lutadores",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LutadorClient create(@RequestBody LutadorClient lutadorClient) {
        return lutadorController.create(lutadorClient);
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
}
