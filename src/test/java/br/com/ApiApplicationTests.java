package br.com;

import br.com.appcinemateca.api.ApiApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
//@TestPropertySource(locations="classpath:test.properties")
class ApiApplicationTests {

	@Test
	void main() {
		ApiApplication.main(new String[] {});

	}
}