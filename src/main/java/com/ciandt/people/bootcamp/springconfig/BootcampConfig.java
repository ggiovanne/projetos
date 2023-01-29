package com.ciandt.people.bootcamp.springconfig;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.ciandt.people.bootcamp")
@EnableJpaRepositories("com.ciandt.people.bootcamp.mvc.repository")
@EntityScan("com.ciandt.people.bootcamp.mvc.repository.model")
public class BootcampConfig {
}
