package com.screenbite.backend.service;

import com.screenbite.backend.model.Movie;
import com.screenbite.backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie>  getMovieByTimeAndDate(String time, String date) {
        return movieRepository.getMovieByTimeAndDate(time, date);
    }
}
