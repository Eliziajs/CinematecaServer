//muitos p um o proprio contrutor faz a associação do muitos p um

package br.com.appcinemateca.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo", nullable = false, length = 250)
	private String titulo;
	@Column(name = "ano")
	private Integer ano;

	@Column(name = "sinopse",nullable = false)
	private String sinopse;

        
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data", updatable = false)
	private Date data = new Date();

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero generos;

	@ManyToOne
	@JoinColumn(name = "diretor_id")
	private Diretor diretor;

        @JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "id.filme") // id.ator estudar o caso
	private Set<Personagem> personagem = new HashSet<>();

	/**@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "filme")
	List<Curtida> curtidas = new ArrayList<>();**/

	public Filme() {
	}

	public Filme(Long id, String titulo, Integer ano, String sinopse, Date data) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
	}

	/**public Filme(Long id, String titulo, Integer ano, String sinopse, Date data, Genero generos, Diretor diretor, Set<Personagem> personagem) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
		this.generos = generos;
		this.diretor = diretor;
		this.personagem = personagem;
	}**/

	public List<Ator> getAtores() {
		List<Ator> lista = new ArrayList<>();
		for (Personagem p : personagem) {
			lista.add(p.getAtor());
		}
		return lista;
	}
	/**public List<Curtida> getCurtida() {
		return curtidas;
	}**/
	/**public  void setUser(List<User> Users) {
		this.users = users;
	}**/

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
		return data;
	}

	public void setDataCadastro(Date data) {
		this.data = data;
	}

	public Genero getGeneros() {
		return generos;
	}

	public void setGeneros(Genero generos) {
		this.generos = generos;
	}
	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
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
