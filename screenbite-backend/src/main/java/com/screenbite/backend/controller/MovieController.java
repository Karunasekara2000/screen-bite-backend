package com.screenbite.backend.controller;


import com.screenbite.backend.model.Movie;
import com.screenbite.backend.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{time}/{day}")
    public ResponseEntity<List<Movie>> getMovieByDateAndTime(@PathVariable String time,@PathVariable String day){
        return ResponseEntity.ok(movieService.getMovieByTimeAndDate(time, day));
    }

}
