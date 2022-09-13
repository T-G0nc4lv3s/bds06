package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserService service;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		User user = service.getProfile();
		UserDTO userDTO = new UserDTO(user);
		Movie movie = movieRepository.getOne(dto.getMovieId());
		Review review = new Review();
		fillEntity(user, movie, review, dto);
		review = repository.save(review);
		return new ReviewDTO(review, userDTO);
	}
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findReview(Long id){
		List<Review> list = repository.findReview(id);
		List<ReviewDTO> result = list.stream().map(x -> new ReviewDTO(x, new UserDTO(x.getUser()))).collect(Collectors.toList());
		return result;
	}

	private void fillEntity(User user, Movie movie, Review review, ReviewDTO dto) {
		review.setText(dto.getText());
		review.setMovie(movie);
		review.setUser(user);
	}

}
