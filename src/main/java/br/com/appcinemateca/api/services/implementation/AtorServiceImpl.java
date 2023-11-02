package br.com.appcinemateca.api.services.implementation;

import br.com.appcinemateca.api.domain.Ator;
import br.com.appcinemateca.api.dto.AtorDTO;
import br.com.appcinemateca.api.repositories.AtorRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.AtorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AtorServiceImpl implements AtorServices {

    @Autowired
    private AtorRepository repository;

    @Autowired
    private ModelMapper mapper;

  
    
   @Override
    public Ator findById(Long id) {
        Optional<Ator> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Ator> findAll() {

        return repository.findAll();
    }

	@Override
    public Ator create(AtorDTO obj) {
        return repository.save(mapper.map(obj, Ator.class));
    }

    @Override
    public Ator update(AtorDTO obj) {
        return repository.save(mapper.map(obj, Ator.class));
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
