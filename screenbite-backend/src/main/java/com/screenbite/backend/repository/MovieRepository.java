package com.screenbite.backend.repository;

import com.screenbite.backend.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getAllMovies();

    List<Movie> getMovieByTimeAndDate(String time, String day);
}
