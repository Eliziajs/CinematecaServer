package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class CadastroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    Long id;

    private String nome;

    private Date nascimento;

    private String email;

    private int status;

    private Date data = new Date();

    public CadastroDTO() {

    }

    public CadastroDTO(Long id, String nome, Date nascimento, String email, int status, Date data) {
        this.id = id;
        this.nome = nome;
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

  /**

    public Status getStatus() {
        return Status.toEnum(status);
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }**/

    public Date getDataCadastro() {
        return data;
    }

    public void setDataCadastro(Date data) {
        this.data = data;
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
        CadastroDTO other = (CadastroDTO) obj;
        return Objects.equals(id, other.id);
    }
}


