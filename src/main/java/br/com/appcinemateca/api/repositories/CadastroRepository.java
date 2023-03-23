package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Cadastro;
import br.com.appcinemateca.api.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    Optional<Person> findByEmail(String email);
}
