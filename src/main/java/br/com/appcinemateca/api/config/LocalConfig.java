package br.com.appcinemateca.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.repositories.PersonRepository;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private PersonRepository repository;

    @Bean
    void startDB() {
        Person u1 = new Person(null, "Valdir", "valdir@mail.com", "123");
        Person u2 = new Person(null, "Luiz", "luiz@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
