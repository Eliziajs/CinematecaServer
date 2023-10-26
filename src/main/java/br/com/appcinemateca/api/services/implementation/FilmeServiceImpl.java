package br.com.appcinemateca.api.services.implementation;


import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.dto.FilmeDTO;
import br.com.appcinemateca.api.repositories.FilmeRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.FilmeServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FilmeServiceImpl implements FilmeServices {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private ModelMapper mapper;

  
    
   @Override
    public Filme findById(Long id) {
        Optional<Filme> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Filme> findAll() {

        return repository.findAll();
    }

	@Override
    public Filme create(FilmeDTO obj) {
        return repository.save(mapper.map(obj, Filme.class));
    }

    @Override
    public Filme update(Long id, FilmeDTO obj) {
        return repository.save(mapper.map(obj, Filme.class));
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
