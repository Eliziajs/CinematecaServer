package br.com.appcinemateca.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.domain.dto.PersonDTO;
import br.com.appcinemateca.api.repositories.PersonRepository;
import br.com.appcinemateca.api.services.PersonServices;
import br.com.appcinemateca.api.services.exceptions.DataIntegratyViolationException;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonServices {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ModelMapper mapper;

  
    
    @Override
    public Person findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }
    
   
	@Override
    public Person create(PersonDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Person.class));
    }

    @Override
    public Person update(PersonDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Person.class));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private void findByEmail(PersonDTO obj) {
        Optional<Person> person = repository.findByEmail(obj.getEmail());
        if(person.isPresent() && !person.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
