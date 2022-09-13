package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;


@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		GenreDTO dto = new GenreDTO(movie.getGenre());
		return new MovieDTO(movie, dto);
	}
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable) {
		genreId = (genreId == 0) ? null : genreId;
		Page<Movie> page = repository.findByGenreId(genreId, pageable);
		return page.map(x -> new MovieDTO(x, new GenreDTO(x.getGenre())));
	}

	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findReview(Long id){
		List<Review> list = reviewRepository.findReview(id);
		List<ReviewDTO> result = list.stream().map(x -> new ReviewDTO(x, new UserDTO(x.getUser()))).collect(Collectors.toList());
		return result;
	}
	
}
