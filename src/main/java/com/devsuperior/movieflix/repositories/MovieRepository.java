package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value = "SELECT obj "
			+ "FROM Movie obj "
			+ "INNER JOIN Genre genre ON obj.genre.id = genre.id "
			+ "WHERE :genreId IS NULL OR obj.genre.id = :genreId ")
	Page<Movie> findByGenreId(Long genreId, Pageable pageable);
}

