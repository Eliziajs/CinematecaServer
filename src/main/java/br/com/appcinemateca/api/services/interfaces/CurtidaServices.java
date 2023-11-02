package br.com.appcinemateca.api.services.interfaces;


import br.com.appcinemateca.api.domain.Curtida;
import br.com.appcinemateca.api.dto.CurtidaDTO;

import java.util.List;

public interface CurtidaServices {

    Curtida findById(Long id);

    List<Curtida> findAll();

    Curtida create(CurtidaDTO obj);

    Curtida update(CurtidaDTO obj);

    void delete(Long id);
    List<Curtida> findByQuantidade(Long quantidade);
    List<Curtida>buscarPorQuantidade(Long quantidade);

}
