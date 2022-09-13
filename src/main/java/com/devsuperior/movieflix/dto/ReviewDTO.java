package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String text;
	
	@Positive(message = "Deve ser um valor positivo")
	@NotNull(message = "Campo requerido")
	private Long movieId;
	
	private UserDTO user;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, Long movieId, UserDTO user) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.user = user;
	}
	
	public ReviewDTO(Review entity, UserDTO dto) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		user = dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
