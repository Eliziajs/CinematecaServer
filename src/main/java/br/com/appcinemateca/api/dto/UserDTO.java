package br.com.appcinemateca.api.dto;

import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.domain.Post;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    Long id;

    private String nome;
    private String sobrenome;

    private Date nascimento;

    private String email;

    private int status;

    private Date data = new Date();

    private String username;

    private String password;
    private Post post;

    private Filme filme;

    public UserDTO(){}

    public UserDTO(Long id, String nome, String sobrenome, Date nascimento, String email, int status, Date data, String username, String password, Post post, Filme filme) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.email = email;
        this.status = status;
        this.data = data;
        this.username = username;
        this.password = password;
        this.post = post;
        this.filme = filme;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return status == userDTO.status && Objects.equals(id, userDTO.id) && Objects.equals(nome, userDTO.nome) && Objects.equals(sobrenome, userDTO.sobrenome) && Objects.equals(nascimento, userDTO.nascimento) && Objects.equals(email, userDTO.email) && Objects.equals(data, userDTO.data) && Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password) && Objects.equals(post, userDTO.post) && Objects.equals(filme, userDTO.filme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, nascimento, email, status, data, username, password, post, filme);
    }
}


