package com.ciandt.people.bootcamp.cleanarch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String name;
    private String login;
}
