package br.com.appcinemateca.api.services;

import java.util.List;

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.domain.dto.PersonDTO;

public interface PersonServices {

    Person findById(Long id);
    List<Person> findAll();
    Person create(PersonDTO obj);
    Person update(PersonDTO obj);
    void delete(Long id);
}
