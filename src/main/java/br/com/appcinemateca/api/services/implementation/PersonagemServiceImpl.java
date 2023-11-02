package br.com.appcinemateca.api.services.implementation;

import br.com.appcinemateca.api.domain.Personagem;
import br.com.appcinemateca.api.dto.PersonagemDTO;
import br.com.appcinemateca.api.repositories.PersonagemRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.PersonagemServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonagemServiceImpl implements PersonagemServices {

    @Autowired
    private PersonagemRepository repository;

    @Autowired
    private ModelMapper mapper;

  
    
   @Override
    public Personagem findById(Long id) {
        Optional<Personagem> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Personagem> findAll() {

        return repository.findAll();
    }

	@Override
    public Personagem create(PersonagemDTO obj) {
        return repository.save(mapper.map(obj, Personagem.class));
    }

    @Override
    public Personagem update(PersonagemDTO obj) {
        return repository.save(mapper.map(obj, Personagem.class));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

   /** private void findByEmail(UserDTO obj) {
        Optional<User> cadastro = repository.findByEmail(obj.getEmail());
        if(cadastro.isPresent() && !cadastro.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }**/
}
