package com.ciandt.people.bootcamp.cleanarch.interfaceadapter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetUserResponse {
    private String name;
    private String userName;
}
