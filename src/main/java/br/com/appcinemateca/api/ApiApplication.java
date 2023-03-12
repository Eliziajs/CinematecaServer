package br.com.appcinemateca.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.repositories.PersonRepository;


@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

    @Autowired
    private PersonRepository repository;
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    public void run(String... args) throws Exception {
    	Person u1 = new Person(null, "Valdir", "valdir@mail.com", "123");
        Person u2 = new Person(null, "Luiz", "luiz@mail.com", "123");
        Person u3 = new Person(null, "Luiza", "luiza@mail.com", "123");

        repository.saveAll(List.of(u1,u2,u3));
    }
}