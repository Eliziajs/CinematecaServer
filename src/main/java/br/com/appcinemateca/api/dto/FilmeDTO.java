//muitos p um o proprio contrutor faz a associação do muitos p um

package br.com.appcinemateca.api.dto;

import br.com.appcinemateca.api.domain.Diretor;
import br.com.appcinemateca.api.domain.Genero;
import br.com.appcinemateca.api.domain.Personagem;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FilmeDTO implements Serializable {
	private static final long serialVersionUID = 1l;

	private Long id;
	private String titulo;
	private Integer ano;
	private String sinopse;
	private Date data = new Date();

	private Genero generos;
	private Diretor diretor;
	private Personagem personagem;

	public FilmeDTO() {

	}

	public FilmeDTO(Long id, String titulo, Integer ano, String sinopse, Date data) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
	}

	/**public FilmeDTO(Long id, String titulo, Integer ano, String sinopse, Date data, Genero generos, Diretor diretor, Personagem personagem) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
		this.generos = generos;
		this.diretor = diretor;
		this.personagem = personagem;
	}**/

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
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
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

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	/**@JsonIgnore
	public Set<PersonagemDTO> getPersonagem() {
		return personagemDTO;
	}

	@JsonIgnore
	public void setPersonagemDTO(Set<Personagem> personagemDTO) {
		this.personagemDTO = personagemDTO;
	}**/


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
		FilmeDTO other = (FilmeDTO) obj;
		return Objects.equals(id, other.id);
	}

}
