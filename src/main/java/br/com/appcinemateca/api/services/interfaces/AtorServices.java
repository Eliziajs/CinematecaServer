package br.com.appcinemateca.api.services.interfaces;


import br.com.appcinemateca.api.domain.Ator;
import br.com.appcinemateca.api.dto.AtorDTO;

import java.util.List;

public interface AtorServices {

    Ator findById(Long id);
    List<Ator> findAll();
    Ator create(AtorDTO obj);
    Ator update(AtorDTO obj);
    void delete(Long id);
}
