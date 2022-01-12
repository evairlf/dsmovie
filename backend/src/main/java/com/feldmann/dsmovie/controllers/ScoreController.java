package com.feldmann.dsmovie.controllers;

import com.feldmann.dsmovie.dtos.MovieDTO;
import com.feldmann.dsmovie.dtos.ScoreDTO;
import com.feldmann.dsmovie.services.MovieService;

import com.feldmann.dsmovie.services.ScoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    private ScoreService service;

    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        MovieDTO movieDTO = service.saveScore(dto);
        return movieDTO;
    }
}