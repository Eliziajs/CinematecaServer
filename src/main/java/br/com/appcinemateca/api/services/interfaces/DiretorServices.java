package br.com.appcinemateca.api.services.interfaces;


import br.com.appcinemateca.api.domain.Diretor;
import br.com.appcinemateca.api.dto.DiretorDTO;

import java.util.List;

public interface DiretorServices {

    Diretor findById(Long id);
    List<Diretor> findAll();
    Diretor create(DiretorDTO obj);
    Diretor update(DiretorDTO obj);
    void delete(Long id);
}
