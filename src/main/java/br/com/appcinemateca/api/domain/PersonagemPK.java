package br.com.appcinemateca.api.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonagemPK implements Serializable {
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;

	//@ManyToOne(cascade= CascadeType.REMOVE)
	@ManyToOne
	@JoinColumn(name = "ator_id")
	private Ator ator;

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
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
		PersonagemPK other = (PersonagemPK) obj;
		return Objects.equals(ator, other.ator) && Objects.equals(filme, other.filme);
	}

}
