package br.com.appcinematecauserResourceJsonTest;

import br.com.appcinemateca.ApiApplication;
import br.com.appcinemateca.api.dto.UserDTO;
import br.com.appcinemateca.configuration.TestConfigs;
import br.com.appcinemateca.integrationTest.containers.AbstractIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class UserResourceJsonTest extends AbstractIntegrationTest{

	private static RequestSpecification specification;
	private static ObjectMapper objectMapper;
	private static UserDTO user = new UserDTO(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);

	
	@BeforeAll
	public static void setup() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		user = new UserDTO(ID, NAME, SOBRENOME, NASCIMENTO, EMAIL, STATUS, DATA);
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
				.body(user)
				.when()
				.post()
			.then()
				.statusCode(200)
			.extract()
				.body()
					.asString();
		
		UserDTO createdUser = objectMapper.readValue(content, UserDTO.class);
		user =createdUser;
		
		assertNotNull(createdUser.getUsername());
		assertNotNull(createdUser.getEmail());
		
		
		assertTrue(createdUser.getId()>0);
		
		assertNotNull("Ana",createdUser.getUsername());
		assertNotNull("ana@email.com",createdUser.getEmail());
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
				.body(user)
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
			.pathParam("id", user.getId())
			.when()
			.get("{id}")
		.then()
			.statusCode(200)
				.extract()
				.body()
					.asString();
		
		UserDTO createdPerson = objectMapper.readValue(content, UserDTO.class);
		user =createdPerson;
		
		assertNotNull(createdPerson.getUsername());
		assertNotNull(createdPerson.getEmail());
		
		
		assertTrue(createdPerson.getId()>0);
		
		assertNotNull("Ana",createdPerson.getUsername());
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
			.pathParam("id", user.getId())
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
		user.setUsername("Ana");
		user.setEmail("ana@email.com");
	}
}
