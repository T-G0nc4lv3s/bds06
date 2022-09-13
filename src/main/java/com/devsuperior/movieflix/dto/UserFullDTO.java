package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.devsuperior.movieflix.entities.User;

public class UserFullDTO extends UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Campo requerido")
	private List<RoleDTO> roles = new ArrayList<>();
	
	public UserFullDTO() {
	}

	public UserFullDTO(Long id, String name, String email) {
		super(id, name, email);
	}

	public UserFullDTO(User entity) {
		super(entity);
		entity.getRoles().forEach(x -> this.roles.add(new RoleDTO(x)));
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}
	
}
