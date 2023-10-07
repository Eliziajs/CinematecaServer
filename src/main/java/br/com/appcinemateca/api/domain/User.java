package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "nome")
        private String nome;
        @Column(name = "sobrenome")
        private String sobrenome;
        @Column(name = "nascimento")
        private Date nascimento;
        @Column(name = "email", unique = true)
        private String email;
        @Column(name = "status")
        private int status;
        @Column(name = "data")
        private Date data = new Date();
        @Column(name = "username", unique = true)
        @NotEmpty(message = "{campo.username.obrigatorio}")
        private String username;
        @Column(name = "password")
        @NotEmpty(message = "{campo.password.obrigatorio}")
        private String password;

        @JsonBackReference
        @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
        List<Curtida> curtidas = new ArrayList<>();

        public User(Long id, String name, String sobrenome, String nascimento, String email, Integer status, String data) {
        }

    public User(Long id, String nome, String sobrenome, Date nascimento, String email, int status, Date data) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.email = email;
        this.status = status;
        this.data = data;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status && Objects.equals(id, user.id) && Objects.equals(nome, user.nome) && Objects.equals(sobrenome, user.sobrenome) && Objects.equals(nascimento, user.nascimento) && Objects.equals(email, user.email) && Objects.equals(data, user.data) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, nascimento, email, status, data, username, password);
    }
}


