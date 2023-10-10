//muitos p um o proprio contrutor faz a associação do muitos p um

package br.com.appcinemateca.api.dto;

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



	public FilmeDTO() {

	}

	public FilmeDTO(Long id, String titulo, Integer ano, String sinopse, Date data) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.data = data;
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

	/**public GeneroDTO getGeneros() {
		return generos;
	}

	public void setGeneros(GeneroDTO generos) {
		this.generos = generos;
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
