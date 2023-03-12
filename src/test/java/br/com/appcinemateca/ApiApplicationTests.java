package br.com.appcinemateca;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.appcinemateca.api.ApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
//@TestPropertySource(locations="classpath:test.properties")
class ApiApplicationTests {

	@Test
	void main() {
		ApiApplication.main(new String[] {});

	}
}