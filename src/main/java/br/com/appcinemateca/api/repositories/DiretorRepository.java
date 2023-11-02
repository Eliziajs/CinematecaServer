package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

}
