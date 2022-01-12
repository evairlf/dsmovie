package com.feldmann.dsmovie.dtos;

public class ScoreDTO {

    private Long movieId;
    private String email;
    private Double score;

    public ScoreDTO(){
    }

    public Long getMovieID() {
        return movieId;
    }

    public void setMovieID(Long movieID) {
        this.movieId = movieID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
