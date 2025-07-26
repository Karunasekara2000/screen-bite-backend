package com.screenbite.backend.repository;

import com.screenbite.backend.model.Food;
import com.screenbite.backend.model.mapper.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Food> getAllFoodDetails() {

        StringBuilder query = new StringBuilder("SELECT id,name,category, " +
                "price, image_url, description FROM food_menu ");

        return jdbcTemplate.query(query.toString(), new FoodMapper());
    }

    @Override
    public List<Food> getFoodDetails(String category) {

        StringBuilder query = new StringBuilder("SELECT id,name,category, " +
                "price, image_url, description FROM food_menu ");

        MapSqlParameterSource param = new MapSqlParameterSource();

        if (category != null){
            query.append(" WHERE category = :category");
            param.addValue("category", category);
        }

        return jdbcTemplate.query(query.toString(), param, new FoodMapper());
    }
}
