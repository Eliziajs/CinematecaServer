package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "curtida")
public class Curtida implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "quantidade")
    public Long quantidade;
    @Column(name = "data")
    private Date data = new Date();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    public Curtida() {
    }

    public Curtida(Long id, Long quantidade, Date data, User user, Filme filme) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
        this.user = user;
        this.filme = filme;
    }

    public User getUser() {
        return user;
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

    public void setDate(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curtida curtida)) return false;
        return Objects.equals(id, curtida.id) && Objects.equals(quantidade, curtida.quantidade) && Objects.equals(data, curtida.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, data);
    }
}

