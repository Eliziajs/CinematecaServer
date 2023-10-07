package br.com.appcinemateca.services.impl;

import br.com.appcinemateca.api.domain.User;
import br.com.appcinemateca.api.dto.UserDTO;
import br.com.appcinemateca.api.repositories.UserRepository;
import br.com.appcinemateca.api.services.exceptions.ObjectNotFoundException;
import br.com.appcinemateca.api.services.implementation.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = UserRepository.class)
class UserServiceImplTest {

    private static final Long ID            = (long) 1;
    private static final Integer INDEX      = 0;
    private static final String  SOBRENOME  = "Januario";
    private static final String DATA        = "20/09/2023";
    private static final String NASCIMENTO = "20/09/1980";
    private static final String NAME       = "Elizia";
    private static final String EMAIL      = "elizia@mail.com";
    private static final String PASSWORD   = "123";
    private static final Integer STATUS   = 1;
    private static final String USERNAME   ="Lindizia";


    private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    private static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-mail já cadastrado no sistema";

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;
    
    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyLong())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);

        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getUsername());

    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {

        when(repository.findById(anyLong()))
                .thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try{
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getNome());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(PASSWORD, response.get(INDEX).getPassword());
        assertEquals(SOBRENOME, response.get(INDEX).getSobrenome());
        assertEquals(STATUS, response.get(INDEX).getStatus());
        assertEquals(NASCIMENTO, response.get(INDEX).getNascimento());
        assertEquals(USERNAME, response.get(INDEX).getUsername());
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);


        User response = service.create(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    /**@Test
    void whenCreateThenReturnAnDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setId((long) 2);
            service.create(userDTO);
        } catch (Exception ex) {
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, ex.getMessage());
        }
    }**/

    @Test
    void whenUpdateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.update(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

   /** @Test
    void whenUpdateThenReturnAnDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setId((long) 2);
            service.create(userDTO);
        } catch (Exception ex) {
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, ex.getMessage());
        }
    }**/

    @Test
    void deleteWithSuccess() {
        when(repository.findById(anyLong())).thenReturn(optionalUser);
        doNothing().when(repository).deleteById(anyLong());
        service.delete(ID);
        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void whenDeleteThenReturnObjectNotFoundException() {
        when(repository.findById(anyLong()))
                .thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));
        try {
            service.delete(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    private void startUser() {
        user = new User(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
        userDTO = new UserDTO(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
        optionalUser = Optional.of(new User(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA));
    }
}
