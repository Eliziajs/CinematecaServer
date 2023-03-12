package br.com.appcinemateca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appcinemateca.api.domain.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}
