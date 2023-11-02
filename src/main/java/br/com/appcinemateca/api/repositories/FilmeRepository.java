package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
