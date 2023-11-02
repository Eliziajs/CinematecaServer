package br.com.appcinemateca.api.dto;

import br.com.appcinemateca.api.domain.Filme;
import br.com.appcinemateca.api.domain.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String mensagem;
	private Date data = new Date();
	private int tipoMsg;

	private User user;
	private Filme filme;

	public PostDTO() {

	}

	public Long getId() {
		return id;
	}

	public PostDTO(Long id, String mensagem, Date data, int tipoMsg, User user, Filme filme) {
		this.id = id;
		this.mensagem = mensagem;
		this.data = data;
		this.tipoMsg = tipoMsg;
		this.user = user;
		this.filme = filme;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTipoMsg() {
		return tipoMsg;
	}

	public void setTipoMsg(int tipoMsg) {
		this.tipoMsg = tipoMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PostDTO postDTO = (PostDTO) o;
		return tipoMsg == postDTO.tipoMsg && Objects.equals(id, postDTO.id) && Objects.equals(mensagem, postDTO.mensagem) && Objects.equals(data, postDTO.data) && Objects.equals(user, postDTO.user) && Objects.equals(filme, postDTO.filme);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mensagem, data, tipoMsg, user, filme);
	}
}
