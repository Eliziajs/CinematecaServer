package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;


public class PersonagemDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private PersonagemPKDTO id = new PersonagemPKDTO();
	private String nome;

	public PersonagemDTO() {

	}

	public PersonagemDTO(String nome, FilmeDTO filme, AtorDTO ator) {
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

	public PersonagemPKDTO getId() {
		return id;
	}

	public void setId(PersonagemPKDTO id) {
		this.id = id;
	}


	public FilmeDTO getFilme() {
		return id.getFilme();
	}

	public AtorDTO getAtor() {
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
		PersonagemDTO other = (PersonagemDTO) obj;
		return Objects.equals(id, other.id);
	}

}
