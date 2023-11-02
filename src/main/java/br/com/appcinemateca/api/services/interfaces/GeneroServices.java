package br.com.appcinemateca.api.services.interfaces;

import br.com.appcinemateca.api.domain.Genero;
import br.com.appcinemateca.api.dto.GeneroDTO;

import java.util.List;

public interface GeneroServices {

   Genero findById(Long id);
    List<Genero> findAll();
    Genero create(GeneroDTO obj);
    Genero update(GeneroDTO obj);
    void delete(Long id);
}
