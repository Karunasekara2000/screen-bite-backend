package com.screenbite.backend.service;

import com.screenbite.backend.model.Food;
import com.screenbite.backend.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoodDetails() {
        return foodRepository.getAllFoodDetails();
    }

    @Override
    public List<Food> getFoodDetails(String category) {
        return foodRepository.getFoodDetails(category);
    }
}
