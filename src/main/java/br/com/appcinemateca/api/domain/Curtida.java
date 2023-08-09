package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private Date date = new Date();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    public Curtida() {
    }

    public Curtida(Long id, Long quantidade, Date date) {
        this.id = id;
        this.quantidade = quantidade;
        this.date = date;
    }
   public Person getPerson() {
        return person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtd() {
        return quantidade;
    }

    public void setQtd(Long qtd) {
        this.quantidade = quantidade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curtida curtida)) return false;
        return Objects.equals(id, curtida.id) && Objects.equals(quantidade, curtida.quantidade) && Objects.equals(date, curtida.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, date);
    }
}

