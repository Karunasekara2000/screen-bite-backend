package com.screenbite.backend.service;

import com.screenbite.backend.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    List<Movie> getMovieByTimeAndDate(String time, String date);
}
