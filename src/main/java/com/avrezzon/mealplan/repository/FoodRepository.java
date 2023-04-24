package com.avrezzon.mealplan.repository;

import com.avrezzon.mealplan.model.Food;

import java.util.List;

public interface FoodRepository{
    List<Food> getAllProteins();
    List<Food> getAllVegetables();
    List<Food> getAllFruits();
    List<Food> getAllCarbohydrates();


}
