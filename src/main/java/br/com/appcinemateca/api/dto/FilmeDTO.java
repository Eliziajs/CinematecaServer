//muitos p um o proprio contrutor faz a associação do muitos p um

package br.com.appcinemateca.api.dto;

import br.com.appcinemateca.api.domain.Ator;
import br.com.appcinemateca.api.domain.Diretor;
import br.com.appcinemateca.api.domain.Genero;
import br.com.appcinemateca.api.domain.Personagem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

public class FilmeDTO implements Serializable {
	private static final long serialVersionUID = 1l;

	private Long id;
	private String titulo;
	private Integer ano;
	private String sinopse;
	private Date data = new Date();

	private GeneroDTO generoDTO;
	private DiretorDTO diretorDTO;
	private PersonagemDTO personagemDTO;

	public FilmeDTO() {

	}
	public FilmeDTO(Long id, String titulo, Integer ano, String sinopse, Date data, GeneroDTO generoDTO, DiretorDTO diretorDTO) {
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
		this.generoDTO = generoDTO;
		this.diretorDTO = diretorDTO;

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
		return data;
	}

	public void setDataCadastro(Date data) {
		this.data = data;
	}

	/**public void setGeneroDTO(GeneroDTO generoDTO) {
		this.generoDTO = generoDTO;
	}
	public DiretorDTO getDiretorDTO() {
		return diretorDTO;
	}

	public void setDiretorDTO(DiretorDTO diretorDTO) {
		this.diretorDTO = diretorDTO;
	}

	public GeneroDTO getGeneroDTO() {
		return generoDTO;
	}

	public PersonagemDTO getPersonagemDTO() {
		return personagemDTO;
	}

	public void setPersonagemDTO(PersonagemDTO personagemDTO) {
		this.personagemDTO = personagemDTO;
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
