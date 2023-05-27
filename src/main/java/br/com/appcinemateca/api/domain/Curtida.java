package br.com.appcinemateca.api.domain;

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
    @Column(name = "qtd")
    public Long qtd;
    @Column(name = "date")
    private Date date;

    public Curtida() {
    }

    public Curtida(Long id, Long qtd, Date date) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curtida curtida)) return false;
        return Objects.equals(id, curtida.id) && Objects.equals(qtd, curtida.qtd) && Objects.equals(date, curtida.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qtd, date);
    }
}

