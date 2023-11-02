package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
