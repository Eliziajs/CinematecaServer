package br.com.appcinemateca.api.services;

import java.util.List;

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.domain.dto.PersonDTO;

public interface PersonService {

    Person findById(Long id);
    List<Person> findAll();
    Person create(PersonDTO obj);
    Person update(PersonDTO obj);
    void delete(Long id);
}
