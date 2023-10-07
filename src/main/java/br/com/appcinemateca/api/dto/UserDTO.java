package br.com.appcinemateca.api.dto;

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

    public UserDTO(Long id, String name, String sobrenome, String nascimento, String email, Integer status, String data){}
    public UserDTO(Long id, String nome, String sobrenome, Date nascimento, String email, int status, Date data) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.email = email;
        this.status = status;
        this.data = data;
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

  /**  public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }**/

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
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", data=" + data +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO that = (UserDTO) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(nascimento, that.nascimento) && Objects.equals(email, that.email) && Objects.equals(data, that.data) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, nascimento, email, status, data, username, password);
    }
}


