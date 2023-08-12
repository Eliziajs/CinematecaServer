package br.com.appcinemateca.api.services.implementation;

import br.com.appcinemateca.api.domain.Genero;
import br.com.appcinemateca.api.dto.GeneroDTO;
import br.com.appcinemateca.api.repositories.GeneroRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.GeneroServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GeneroServiceImpl implements GeneroServices {

    @Autowired
    private GeneroRepository repository;

    @Autowired
    private ModelMapper mapper;
    
   @Override
    public Genero findById(Long id) {
        Optional<Genero> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Genero> findAll() {

        return repository.findAll();
    }

	@Override
    public Genero create(GeneroDTO obj) {
        return repository.save(mapper.map(obj, Genero.class));
    }

    @Override
    public Genero update(GeneroDTO obj) {
        return repository.save(mapper.map(obj, Genero.class));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

   /** private void findByEmail(CadastroDTO obj) {
        Optional<Cadastro> cadastro = repository.findByEmail(obj.getEmail());
        if(cadastro.isPresent() && !cadastro.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }**/
}
