package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;


public class AtorDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String nome;

    public AtorDTO() {

    }

    public AtorDTO(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AtorDTO other = (AtorDTO) obj;
        return Objects.equals(id, other.id);
    }

}
