package com.feldmann.dsmovie.services;

import com.feldmann.dsmovie.dtos.MovieDTO;
import com.feldmann.dsmovie.dtos.ScoreDTO;
import com.feldmann.dsmovie.entities.Movie;
import com.feldmann.dsmovie.entities.Score;
import com.feldmann.dsmovie.entities.User;
import com.feldmann.dsmovie.repositories.MovieRepository;
import com.feldmann.dsmovie.repositories.ScoreRepository;
import com.feldmann.dsmovie.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    private MovieRepository movieRepository;
    private ScoreRepository scoreRepository;
    private UserRepository userRepository;

    public ScoreService(MovieRepository movieRepository, ScoreRepository scoreRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        //findById retorna optional por isso tem que ter o get()
        Movie movie = movieRepository.findById(dto.getMovieID()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum += s.getValue();
        }
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }


}
