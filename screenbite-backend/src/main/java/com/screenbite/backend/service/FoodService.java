package com.screenbite.backend.service;

import com.screenbite.backend.model.Food;

import java.util.List;

public interface FoodService {

    List<Food> getAllFoodDetails();
    List<Food> getFoodDetails(String category);

}
