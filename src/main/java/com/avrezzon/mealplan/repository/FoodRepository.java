package com.avrezzon.mealplan.repository;

import com.avrezzon.mealplan.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface FoodRepository{
    List<Food> getAllProteins();
    List<Food> getAllVegetables();
    List<Food> getAllFruits();
    List<Food> getAllCarbohydrates();


}
