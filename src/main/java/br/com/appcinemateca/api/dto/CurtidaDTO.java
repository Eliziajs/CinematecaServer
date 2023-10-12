package br.com.appcinemateca.api.dto;

//Avaliar o tipo de dado long para o atributo qtd

import br.com.appcinemateca.api.domain.Curtida;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class CurtidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Long quantidade;

    private Date data = new Date();
    private FilmeDTO filmeDTO;
    private UserDTO userDTO;

    public CurtidaDTO() {
    }

    public CurtidaDTO(Long id, Long quantidade, Date data, FilmeDTO filmeDTO, UserDTO userDTO) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
        this.filmeDTO = filmeDTO;
        this.userDTO = userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CurtidaDTO other = (CurtidaDTO) obj;
        return Objects.equals(id, other.id);
    }
}

