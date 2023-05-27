package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

}
