package br.com.appcinemateca.api.services.interfaces;

import br.com.appcinemateca.api.domain.Cadastro;
import br.com.appcinemateca.api.dto.CadastroDTO;

import java.util.List;

public interface CadastroServices {

    Cadastro findById(Long id);
    List<Cadastro> findAll();
    Cadastro create(CadastroDTO obj);
    Cadastro update(CadastroDTO obj);
    void delete(Long id);
}
