package com.avrezzon.mealplan.controller;

import com.avrezzon.mealplan.model.CaloricIntake;
import com.avrezzon.mealplan.model.DailyMealPlan;
import com.avrezzon.mealplan.service.DailyMealPlanLayoutFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("meal")
public class MealController {
    @GetMapping
    public DailyMealPlan getMealPlanLayout(@RequestParam String calories){

        log.info("Generating meal plan for {} calories.", calories);

        switch (calories) {
            case "1200" -> {
                return DailyMealPlanLayoutFactory.getDailyMealPlan(CaloricIntake.CALORIES_1200);
            }
            case "1500" -> {
                return DailyMealPlanLayoutFactory.getDailyMealPlan(CaloricIntake.CALORIES_1500);
            }
            case "1800" -> {
                return DailyMealPlanLayoutFactory.getDailyMealPlan(CaloricIntake.CALORIES_1800);
            }
            case "2000" -> {
                return DailyMealPlanLayoutFactory.getDailyMealPlan(CaloricIntake.CALORIES_2000);
            }
            case "2500" -> {
                return DailyMealPlanLayoutFactory.getDailyMealPlan(CaloricIntake.CALORIES_2500);
            }
            default -> throw new IllegalStateException();
        }
    }



}
