package br.com.appcinemateca.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI CustonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("App Cinemateca with Java 17 and Spring Boot 4")
                        .version("")
                        .description("")
                        .termsOfService("link")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("link")));
    }

}
