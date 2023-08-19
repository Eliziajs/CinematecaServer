package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genero")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;

	@JsonBackReference
	@OneToMany(mappedBy = "generos")
	List<Filme> filmes = new ArrayList<>();

	public Genero() {

	}
	public Genero(Long id, String nome, String descricao) {
		super();
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Genero genero = (Genero) o;
		return Objects.equals(id, genero.id) && Objects.equals(nome, genero.nome) && Objects.equals(descricao, genero.descricao) && Objects.equals(filmes, genero.filmes);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nome, descricao, filmes);
	}

	@Override
	public String toString() {
		return "Genero{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", filmes=" + filmes +
				'}';
	}
}
