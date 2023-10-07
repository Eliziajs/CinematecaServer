package br.com.appcinemateca.api.services.implementation;


import br.com.appcinemateca.api.domain.User;
import br.com.appcinemateca.api.dto.UserDTO;
import br.com.appcinemateca.api.repositories.UserRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.interfaces.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
    @Override
    public User create(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }


    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }


}
