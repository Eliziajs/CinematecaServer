package br.com.appcinemateca;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.boot.SpringApplication;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

//SpringBootApplication
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);


       /** Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5());
        PasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder("pbkdf2", encoders);


        String result = passwordEncoder.encode("admin234");
        System.out.println("My hash " + result);**/

    }
}

