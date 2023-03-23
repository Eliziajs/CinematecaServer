package br.com.appcinemateca.api.services.implementation;

import br.com.appcinemateca.api.domain.Cadastro;
import br.com.appcinemateca.api.dto.CadastroDTO;
import br.com.appcinemateca.api.repositories.CadastroRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.CadastroServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CadastroServiceImpl implements CadastroServices {

    @Autowired
    private CadastroRepository repository;

    @Autowired
    private ModelMapper mapper;

  
    
   @Override
    public Cadastro findById(Long id) {
        Optional<Cadastro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Cadastro> findAll() {

        return repository.findAll();
    }

	@Override
    public Cadastro create(CadastroDTO obj) {
        return repository.save(mapper.map(obj, Cadastro.class));
    }

    @Override
    public Cadastro update(CadastroDTO obj) {
        return repository.save(mapper.map(obj, Cadastro.class));
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
