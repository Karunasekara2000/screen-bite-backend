package com.screenbite.backend.repository;

import com.screenbite.backend.model.Food;

import java.util.List;

public interface FoodRepository {

    List<Food> getAllFoodDetails();
    List<Food> getFoodDetails(String category);

}
