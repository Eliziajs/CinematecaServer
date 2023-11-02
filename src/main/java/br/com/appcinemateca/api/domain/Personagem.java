package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "personagem")
public class Personagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PersonagemPK id = new PersonagemPK();
	@Column(name = "nome")
	private String nome;

	public Personagem() {

	}

	public Personagem(String nome, Filme filme, Ator ator) {
		super();
		this.nome = nome;
		id.setAtor(ator);
		id.setFilme(filme);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PersonagemPK getId() {
		return id;
	}

	public void setId(PersonagemPK id) {
		this.id = id;
	}

	@JsonIgnore
	public Filme getFilme() {
		return id.getFilme();
	}

	@JsonIgnore
	public Ator getAtor() {
		return id.getAtor();
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
		Personagem other = (Personagem) obj;
		return Objects.equals(id, other.id);
	}

}
