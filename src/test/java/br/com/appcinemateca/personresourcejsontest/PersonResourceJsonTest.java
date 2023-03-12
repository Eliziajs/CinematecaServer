package br.com.appcinemateca.personresourcejsontest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.appcinemateca.api.ApiApplication;
import br.com.appcinemateca.configuration.TestConfigs;
import br.com.appcinemateca.integrationTest.containers.AbstractIntegrationTest;
import br.com.appcinemateca.integrationtests.vo.PersonDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PersonResourceJsonTest extends AbstractIntegrationTest{

	private static RequestSpecification specification;
	private static ObjectMapper objectMapper;
	private static PersonDTO person;
	
	@BeforeAll
	public static void setup() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		person =new PersonDTO();
	}
	
	@Test
	@Order(1)
	public void testCreate() throws JsonMappingException, JsonProcessingException {
		mockPerson();
		specification = new RequestSpecBuilder()
				.addHeader(TestConfigs.HEADER_PARAM_ORIGIN,"http://localhost:8080")
				.setBasePath("http://localhost:8080/user")
				.setPort(TestConfigs.SERVER_PORT)
					.addFilter(new RequestLoggingFilter(LogDetail.ALL))
					.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
				.build();
		var content =
			given().spec(specification)
			.contentType(TestConfigs.CONTENT_TYPE_JSON)
				.body(person)
				.when()
				.post()
			.then()
				.statusCode(200)
			.extract()
				.body()
					.asString();
		
		PersonDTO createdPerson = objectMapper.readValue(content, PersonDTO.class);
		person =createdPerson;
		
		assertNotNull(createdPerson.getName());
		assertNotNull(createdPerson.getEmail());
		
		
		assertTrue(createdPerson.getId()>0);
		
		assertNotNull("Ana",createdPerson.getName());
		assertNotNull("ana@email.com",createdPerson.getEmail());

			
	}

	@Test
	@Order(2)
	public void testCreateWihtErrorOrigin() throws JsonMappingException, JsonProcessingException {
		mockPerson();
		specification = new RequestSpecBuilder()
				.addHeader(TestConfigs.HEADER_PARAM_ORIGIN,"http://localhost:8080")
				.setBasePath("http://localhost:8080")
				.setPort(TestConfigs.SERVER_PORT)
					.addFilter(new RequestLoggingFilter(LogDetail.ALL))
					.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
				.build();
		var content =
			given().spec(specification)
			.contentType(TestConfigs.CONTENT_TYPE_JSON)
				.body(person)
				.when()
				.post()
			.then()
				
				.statusCode(403)
					.extract()
				.body()
					.asString();
		
		
		assertNotNull(content);
		assertEquals("Invalid CORS request",content);
		
	}
		
			
	@Test
	@Order(3)
	public void testFindById() throws JsonMappingException, JsonProcessingException {
		mockPerson();
		specification = new RequestSpecBuilder()
				.addHeader(TestConfigs.HEADER_PARAM_ORIGIN,"http://localhost:8080")
				.setBasePath("http://localhost:8080")
				.setPort(TestConfigs.SERVER_PORT)
					.addFilter(new RequestLoggingFilter(LogDetail.ALL))
					.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
				.build();
		var content =
			given().spec(specification)
			.contentType(TestConfigs.CONTENT_TYPE_JSON)
			.pathParam("id", person.getId())
			.when()
			.get("{id}")
		.then()
			.statusCode(200)
				.extract()
				.body()
					.asString();
		
		PersonDTO createdPerson = objectMapper.readValue(content, PersonDTO.class);
		person =createdPerson;
		
		assertNotNull(createdPerson.getName());
		assertNotNull(createdPerson.getEmail());
		
		
		assertTrue(createdPerson.getId()>0);
		
		assertNotNull("Ana",createdPerson.getName());
		assertNotNull("ana@email.com",createdPerson.getEmail());
	}

	@Test
	@Order(4)
	public void testFindByIdwhithErrorOrigin() throws JsonMappingException, JsonProcessingException {
		mockPerson();
		specification = new RequestSpecBuilder()
				.addHeader(TestConfigs.HEADER_PARAM_ORIGIN,"http://localhost:8080")
				.setBasePath("http://localhost:8080")
				.setPort(TestConfigs.SERVER_PORT)
					.addFilter(new RequestLoggingFilter(LogDetail.ALL))
					.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
				.build();
		var content =
			given().spec(specification)
			.contentType(TestConfigs.CONTENT_TYPE_JSON)
			.pathParam("id", person.getId())
			.when()
			.get("{id}")
		.then()
			.statusCode(403)
				.extract()
				.body()
					.asString();
		
		assertNotNull(content);
		assertEquals("Invalid CORS request", content);
	}

	private void mockPerson() {
		person.setName("Ana");
		person.setEmail("ana@email.com");
		
		
	}

	


}
