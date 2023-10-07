package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;


public class PersonagemDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private PersonagemPKDTO id = new PersonagemPKDTO();
	private String personagem;

	public PersonagemDTO() {

	}

	public PersonagemDTO(String personagem, FilmeDTO filme, AtorDTO ator) {
		super();
		this.personagem = personagem;
		id.setAtor(ator);
		id.setFilme(filme);
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
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
