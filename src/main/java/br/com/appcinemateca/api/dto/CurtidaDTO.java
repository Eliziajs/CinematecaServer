package br.com.appcinemateca.api.dto;

//Avaliar o tipo de dado long para o atributo qtd

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class CurtidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Long qtd;

    private Date date;

    public CurtidaDTO() {
    }

    public CurtidaDTO(Long id, Long qtd, Date date) {
        this.id = id;
        this.qtd = qtd;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        CadastroDTO other = (CadastroDTO) obj;
        return Objects.equals(id, other.id);
    }
}

