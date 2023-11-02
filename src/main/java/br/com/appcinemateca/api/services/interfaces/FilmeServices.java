package br.com.appcinemateca.api.services.interfaces;

import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.dto.FilmeDTO;

import java.util.List;

public interface FilmeServices {
    Filme findById(Long id);
    List<Filme> findAll();
    Filme create(FilmeDTO obj);
    Filme update(Long id, FilmeDTO obj);
    void delete(Long id);
}
