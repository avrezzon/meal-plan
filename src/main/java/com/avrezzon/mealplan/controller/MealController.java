package com.avrezzon.mealplan.controller;

import com.avrezzon.mealplan.model.Meal;
import com.avrezzon.mealplan.model.MealTemplate;
import com.avrezzon.mealplan.service.MealPlanner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("meal")
@RequiredArgsConstructor
public class MealController {
    private final MealPlanner mealPlanner;

    @GetMapping
    public List<MealTemplate> getMealPlanTemplate(@RequestParam Integer calories) {
        return mealPlanner.generateMealPlan(calories);
    }

    @PostMapping
    public List<Meal> getSampleMealPlan(@RequestParam Integer calories) {
        log.info("Generating meal plan example for {} calories.", calories);
        return mealPlanner.generateExampleMealPlan(calories);
    }


}
