package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	@Size(min = 3, max = 60, message = "O campo deve ter entre 3 e 60 caracteres")
	private String name;
	
	@Email(message = "Entre com email válido")
	private String email;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
