package br.com.appcinemateca.api.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "mensagens")
	private String mensagem;
	@Column(name = "Data")
	private Date data;
	//@Column(name = "tipoMsg")
	//private int tipoMsg;
	

	/*@JsonIgnore
	@ManyToMany (mappedBy = "mensagens")
	private List<Pessoa> pessoas = new  ArrayList<>();*/

	public Post() {
		
	}
	public Post(Long id, String mensagem, Date data) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.data = data;
		
	}
	
	
	/*public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}*/

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

	/*public TipoMensagem getTipoMsg() {
		return TipoMensagem.toEnum(tipoMsg);
	}*/
	
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
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
