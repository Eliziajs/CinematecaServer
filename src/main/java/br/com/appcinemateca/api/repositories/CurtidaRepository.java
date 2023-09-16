package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;


public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    // List<Curtida> findByQuantidade(Long quantidade);

    List<Curtida> findByQuantidadeAndFilme_id(Long quantidade, Long filme_id);
    @Query("from Curtida t where t.quantidade =:quantidade")// verificar sintaxe de não nullo
     List<Curtida>buscarPorQuantidade(Long quantidade);//ver sem parametro

}
