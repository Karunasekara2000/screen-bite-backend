package com.screenbite.backend.model.mapper;

import com.screenbite.backend.model.Food;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodMapper implements RowMapper<Food> {
    @Override
    public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Food.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .category(rs.getString("category"))
                .price(rs.getInt("price"))
                .url(rs.getString("image_url"))
                .description(rs.getString("description"))
                .build();
    }
}
