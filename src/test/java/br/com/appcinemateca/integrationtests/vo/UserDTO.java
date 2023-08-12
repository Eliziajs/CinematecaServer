package br.com.appcinemateca.integrationtests.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1l;
	private Long id;

	private String userName;
	private String email;
	private String password;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String userName, String email, String password) {
		super();
		this.id = id;
		this.userName= userName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String name) {
		this.userName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
