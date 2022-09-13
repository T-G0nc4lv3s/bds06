package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 4, max = 20, message = "O campo deve ter entre 4 e 20 caracteres")
	@NotBlank
	private String name;
	
	public GenreDTO() {
	}

	public GenreDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public GenreDTO(Genre entity) {
		id = entity.getId();
		name = entity.getName();
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
	
}
