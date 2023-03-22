package br.com.appcinemateca.resources;

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

import br.com.appcinemateca.api.domain.Person;
import br.com.appcinemateca.api.dto.PersonDTO;
import br.com.appcinemateca.api.resources.PersonResource;
import br.com.appcinemateca.api.services.implementation.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.Mockito.*;

@SpringBootTest
class PersonResourceTest {

    private static final Long ID      = (long) 1;
    private static final Integer INDEX   = 0;
    private static final String NAME     = "Valdir";
    private static final String EMAIL    = "valdir@mail.com";
    private static final String PASSWORD = "123";

    private Person person = new Person();
    private PersonDTO personDTO = new PersonDTO();

    @InjectMocks
    private PersonResource resource;

    @Mock
    private PersonServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyLong())).thenReturn(person);
        when(mapper.map(any(), any())).thenReturn(personDTO);

        ResponseEntity<PersonDTO> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PersonDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

   @Test
    void whenFindAllThenReturnAListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(person));
        when(mapper.map(any(), any())).thenReturn(personDTO);

        ResponseEntity<CollectionModel<PersonDTO>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(PersonDTO.class, ((List<?>) response.getBody()).get(INDEX).getClass());

        assertEquals(ID, ((Person) ((List<?>) response.getBody()).get(INDEX)).getId());
        assertEquals(NAME, ((Person) ((List<?>) response.getBody()).get(INDEX)).getName());
        assertEquals(EMAIL, ((Person) ((List<?>) response.getBody()).get(INDEX)).getEmail());
        assertEquals(PASSWORD, ((Person) ((List<?>) response.getBody()).get(INDEX)).getPassword());
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(person);

        ResponseEntity<PersonDTO> response = resource.create(personDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(personDTO)).thenReturn(person);
        when(mapper.map(any(), any())).thenReturn(personDTO);

        ResponseEntity<PersonDTO> response = resource.update(ID, personDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PersonDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
    }

    @Test
    void whenDeleteThenReturnSuccess() {
        doNothing().when(service).delete(anyLong());

        ResponseEntity<PersonDTO> response = resource.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).delete(anyLong());
    }

    private void startUser() {
        person = new Person(ID, NAME, EMAIL,  PASSWORD);
        personDTO = new PersonDTO(ID, NAME, EMAIL, PASSWORD);
    }
}