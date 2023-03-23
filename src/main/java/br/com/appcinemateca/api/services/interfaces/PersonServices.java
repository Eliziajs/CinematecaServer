package br.com.appcinemateca.api.services.interfaces;

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.dto.PersonDTO;

import java.util.List;

public interface PersonServices {

    Person findById(Long id);
    List<Person> findAll();
    Person create(PersonDTO obj);
    Person update(PersonDTO obj);
    void delete(Long id);
}
