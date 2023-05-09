package br.com.appcinemateca.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;

	private String mensagem;

	private Date data;

	private int tipoMsg;

	public PostDTO() {
		
	}
	public PostDTO(Long id, String mensagem, Date data) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.data = data;

		
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
		PostDTO other = (PostDTO) obj;
		return Objects.equals(id, other.id);
	}

}
