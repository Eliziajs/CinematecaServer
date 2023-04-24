//muitos p um o proprio contrutor faz a associação do muitos p um

package br.com.appcinemateca.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "ano")
	private Integer ano;
	@Column(name = "sinopse")
	private String sinopse;
	@Column(name = "dataCadastro")
	private Date dataCadastro = new Date();

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero generos;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "diretor_id")
	private Diretor diretor;

	@JsonManagedReference
	@OneToMany(mappedBy = "id.filme") // id.ator estudar o caso
	private Set<Personagem> personagem = new HashSet<>();

	List<Pessoa> pessoas = new ArrayList<>();

	public Filme() {

	}

	public Filme(Long id, String titulo, Integer ano, String sinopse, Genero generos, Diretor diretor, Date dataCadastro) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.generos = generos;
		this.diretor = diretor;
		this.dataCadastro = dataCadastro;

	}

	public List<Ator> getAtores() {
		List<Ator> lista = new ArrayList<>();
		for (Personagem p : personagem) {
			lista.add(p.getAtor());
		}
		return lista;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Genero getGeneros() {
		return generos;
	}

	public void setGeneros(Genero generos) {
		this.generos = generos;
	}

	@JsonIgnore
	public Set<Personagem> getPersonagem() {
		return personagem;
	}

	@JsonIgnore
	public void setPersonagem(Set<Personagem> personagem) {
		this.personagem = personagem;
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
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}

}
