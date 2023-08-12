package br.com.appcinemateca.api.services.implementation;


import br.com.appcinemateca.api.domain.Post;
import br.com.appcinemateca.api.dto.PostDTO;
import br.com.appcinemateca.api.repositories.PostRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.PostServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostServices {

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper mapper;

   @Override
    public Post findById(Long id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };   
    @Override
    public List<Post> findAll() {

        return repository.findAll();
    }

	@Override
    public Post create(PostDTO obj) {
        return repository.save(mapper.map(obj, Post.class));
    }

    @Override
    public Post update(PostDTO obj) {
        return repository.save(mapper.map(obj, Post.class));
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
