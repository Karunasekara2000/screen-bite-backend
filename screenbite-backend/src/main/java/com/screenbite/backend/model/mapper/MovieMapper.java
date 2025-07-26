package com.screenbite.backend.model.mapper;

import com.screenbite.backend.model.Movie;
import com.screenbite.backend.model.enumeration.Day;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Movie.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .day(Day.valueOf(rs.getString("day")))
                .time(rs.getTime("time"))
                .url(rs.getString("image_url"))
                .description(rs.getString("description"))
                .build();
    }
}
