package br.com.appcinemateca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

    //@Autowired
    //private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

   public void run(String... args) throws Exception { }
}