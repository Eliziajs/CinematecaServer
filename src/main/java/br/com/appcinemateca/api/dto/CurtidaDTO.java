package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;


public class CurtidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public CurtidaDTO(Long id) {
        this.setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

