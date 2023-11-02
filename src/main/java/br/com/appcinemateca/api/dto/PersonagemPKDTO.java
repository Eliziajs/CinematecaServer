package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class PersonagemPKDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private FilmeDTO filme;

	private AtorDTO ator;

	public FilmeDTO getFilme() {
		return filme;
	}

	public void setFilme(FilmeDTO filme) {
		this.filme = filme;
	}

	public AtorDTO getAtor() {
		return ator;
	}

	public void setAtor(AtorDTO ator) {
		this.ator = ator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ator, filme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonagemPKDTO other = (PersonagemPKDTO) obj;
		return Objects.equals(ator, other.ator) && Objects.equals(filme, other.filme);
	}

}
