package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Objects;


public class GeneroDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;

	private String nome;
	private String descricao;

	public GeneroDTO() { }

	public GeneroDTO(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		GeneroDTO other = (GeneroDTO) obj;
		return Objects.equals(id, other.id);
	}

}
