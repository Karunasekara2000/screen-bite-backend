package com.screenbite.backend.controller;

import com.screenbite.backend.model.Food;
import com.screenbite.backend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    @GetMapping()
    public ResponseEntity<List<Food>> getAllFoodInfo(){

        return ResponseEntity.ok(foodService.getAllFoodDetails());
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Food>> getFoodInfo(@RequestBody(required = false) String category){

        return ResponseEntity.ok(foodService.getFoodDetails(category));
    }
}
