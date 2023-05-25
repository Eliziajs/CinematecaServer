package br.com.appcinemateca.api.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "curtida")
public class Curtida implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private Long count;

    public Curtida(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curtida curtida)) return false;
        return Objects.equals(id, curtida.id) && Objects.equals(count, curtida.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }
}
