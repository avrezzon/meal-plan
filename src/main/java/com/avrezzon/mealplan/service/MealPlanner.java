package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.model.Meal;
import com.avrezzon.mealplan.model.MealTemplate;

import java.util.List;

public interface MealPlanner {

    List<MealTemplate> generateMealPlan(Integer calories);
    List<Meal> generateExampleMealPlan(Integer calories);

}
