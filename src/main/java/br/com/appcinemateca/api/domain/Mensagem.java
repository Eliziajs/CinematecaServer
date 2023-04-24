package br.com.appcinemateca.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensagens")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "mensagens")
	private String mensagem;
	@Column(name = "Data")
	private Date data;
	@Column(name = "tipoMsg")
	private int tipoMsg;
	

	@JsonIgnore
	@ManyToMany (mappedBy = "mensagens")
	private List<Pessoa> pessoas = new  ArrayList<>();

	public Mensagem() {
		
	}
	public Mensagem(Long id, String mensagem, Date data, TipoMensagem tipoMsg) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.data = data;
		this.tipoMsg = tipoMsg.getCod();
		
	}
	
	
	public List<Pessoa> getPessoas() {
		return pessoas;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String Mensagem) {
		this.mensagem = Mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoMensagem getTipoMsg() {
		return TipoMensagem.toEnum(tipoMsg);
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
		Mensagem other = (Mensagem) obj;
		return Objects.equals(id, other.id);
	}

}
