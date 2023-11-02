package br.com.appcinemateca.api.services.implementation;

import br.com.appcinemateca.api.domain.Diretor;
import br.com.appcinemateca.api.dto.DiretorDTO;
import br.com.appcinemateca.api.repositories.DiretorRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.DiretorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DiretorServiceImpl implements DiretorServices {

    @Autowired
    private DiretorRepository repository;

    @Autowired
    private ModelMapper mapper;
   @Override
    public Diretor findById(Long id) {
        Optional<Diretor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Diretor> findAll() {

        return repository.findAll();
    }

	@Override
    public Diretor create(DiretorDTO obj) {
        return repository.save(mapper.map(obj, Diretor.class));
    }

    @Override
    public Diretor update(DiretorDTO obj) {
        return repository.save(mapper.map(obj, Diretor.class));
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
