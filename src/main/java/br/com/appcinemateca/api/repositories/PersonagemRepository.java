package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}
