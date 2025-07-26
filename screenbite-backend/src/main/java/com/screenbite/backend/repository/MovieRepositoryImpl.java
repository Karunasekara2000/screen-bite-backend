package com.screenbite.backend.repository;

import com.screenbite.backend.model.Movie;
import com.screenbite.backend.model.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository{

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Movie> getAllMovies() {

        StringBuilder query = new StringBuilder("SELECT id,title,day,time,image_url,description FROM movie");
        return namedParameterJdbcTemplate.query(query.toString(), new MovieMapper());
    }

    @Override
    public List<Movie>  getMovieByTimeAndDate(String time, String day) {

        StringBuilder query = new StringBuilder("SELECT id,title,day,time,image_url,description FROM movie " +
                " WHERE time = :time AND day = :day");
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("time", time);
        param.addValue("day", day);

        return namedParameterJdbcTemplate.query(query.toString(), param, new MovieMapper());
    }
}
