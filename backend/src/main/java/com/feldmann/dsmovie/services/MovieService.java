package com.feldmann.dsmovie.services;

import com.feldmann.dsmovie.dtos.MovieDTO;
import com.feldmann.dsmovie.entities.Movie;
import com.feldmann.dsmovie.repositories.MovieRepository;

import com.feldmann.dsmovie.repositories.ScoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository repository) {
        movieRepository = repository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findall(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie result = movieRepository.findById(id).get();
        MovieDTO movie = new MovieDTO(result);
        return movie;
    }

}
