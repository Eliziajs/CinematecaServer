package br.com.appcinemateca.api.dto;

//Avaliar o tipo de dado long para o atributo qtd

import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.domain.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class CurtidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Long quantidade;

    private Date data = new Date();
    private Filme filme;
    private User user;

    public CurtidaDTO() {
    }

    public CurtidaDTO(Long id, Long quantidade, Date data) {
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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurtidaDTO that = (CurtidaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(quantidade, that.quantidade) && Objects.equals(data, that.data) && Objects.equals(filme, that.filme) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, data, filme, user);
    }
}

