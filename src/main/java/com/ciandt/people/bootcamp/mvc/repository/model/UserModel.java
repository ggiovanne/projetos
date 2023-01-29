package com.ciandt.people.bootcamp.mvc.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_USERS")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    @NotEmpty(message = "name cannot be empty")
    @NotNull(message = "name cannot be null")
    private String name;

    @Column(name = "login", unique = true)
    @NotEmpty(message = "login cannot be empty")
    @NotNull(message = "login cannot be null")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "password cannot be empty")
    @NotNull(message = "password cannot be null")
    private String password;
}
