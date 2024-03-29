package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;

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
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data")
    private Date data = new Date();


    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    public Curtida() {
    }

    public Curtida(Long id, Long quantidade, Date data) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
      
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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

