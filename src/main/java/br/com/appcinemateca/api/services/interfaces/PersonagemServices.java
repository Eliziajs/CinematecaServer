package br.com.appcinemateca.api.services.interfaces;

import br.com.appcinemateca.api.domain.Personagem;
import br.com.appcinemateca.api.dto.PersonagemDTO;

import java.util.List;

public interface PersonagemServices {

    Personagem findById(Long id);
    List<Personagem> findAll();
    Personagem create(PersonagemDTO obj);
    Personagem update(PersonagemDTO obj);
    void delete(Long id);
}
