package com.feldmann.dsmovie.repositories;

import com.feldmann.dsmovie.entities.Movie;
import com.feldmann.dsmovie.entities.Score;
import com.feldmann.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
    
}
