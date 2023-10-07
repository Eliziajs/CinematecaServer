package br.com.appcinemateca.resources;

import br.com.appcinemateca.api.domain.User;
import br.com.appcinemateca.api.dto.UserDTO;
import br.com.appcinemateca.api.repositories.UserRepository;
import br.com.appcinemateca.api.resources.UserResource;
import br.com.appcinemateca.api.services.implementation.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = UserRepository.class)
class UserResourceTest {

    private static final Long ID      = (long) 1;
    private static final Integer INDEX      = 0;
    private static final String  SOBRENOME  = "Januario";
    private static final String DATA        = "20/09/2023";
    private static final String NASCIMENTO = "20/09/1980";
    private static final String NAME       = "Elizia";
    private static final String EMAIL      = "elizia@mail.com";
    private static final String PASSWORD   = "123";
    private static final Integer STATUS   = 1;
    private static final String USERNAME   ="Lindizia";

    private User user = new User(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
    private UserDTO userDTO = new UserDTO(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);


    @InjectMocks
    private UserResource resource;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyLong())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getUsername());

    }

   @Test
    void whenFindAllThenReturnAListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(user));
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<CollectionModel<UserDTO>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(CollectionModel.class, response.getBody().getClass());
        assertEquals(UserDTO.class, ((List<?>) response.getBody()).get(INDEX).getClass());

        assertEquals(ID, ((User) ((List<?>) response.getBody()).get(INDEX)).getId());
        assertEquals(NAME, ((User) ((List<?>) response.getBody()).get(INDEX)).getUsername());
        assertEquals(PASSWORD, ((User) ((List<?>) response.getBody()).get(INDEX)).getPassword());
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<UserDTO> response = resource.create(userDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(userDTO)).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.update(ID, userDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getUsername());

    }

    @Test
    void whenDeleteThenReturnSuccess() {
        doNothing().when(service).delete(anyLong());

        ResponseEntity<UserDTO> response = resource.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).delete(anyLong());
    }

    private void startUser() {
        user = new User(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
        userDTO = new UserDTO(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
    }
}