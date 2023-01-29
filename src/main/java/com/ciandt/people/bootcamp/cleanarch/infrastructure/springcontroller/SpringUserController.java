package com.ciandt.people.bootcamp.cleanarch.infrastructure.springcontroller;

import com.ciandt.people.bootcamp.cleanarch.domain.exception.UserNotFoundException;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.UserController;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model.GetUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@Component
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringUserController {
    private final UserController userController;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getByName(@RequestParam String name) {
        log.info("getByName with name: {}", name);

        return userController.getByName(name);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("handling illegal argument exception with message: {}", ex.getMessage());

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Void> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("handling user not found exception with message: {}", ex.getMessage());

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
