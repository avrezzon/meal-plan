package com.avrezzon.mealplan.repository;

import com.avrezzon.mealplan.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MealRepository extends MongoRepository<Meal, Meal.MealReference> {

    List<Meal> findAllByIdUsername(String username);
}
