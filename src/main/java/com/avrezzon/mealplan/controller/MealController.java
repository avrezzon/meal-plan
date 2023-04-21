package com.avrezzon.mealplan.controller;

import com.avrezzon.mealplan.model.DailyMealPlan;
import com.avrezzon.mealplan.model.DailyMealPlanTemplate;
import com.avrezzon.mealplan.service.MealPlannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("meal")
@RequiredArgsConstructor
public class MealController {

    private final MealPlannerService service;
    @GetMapping
    public DailyMealPlanTemplate getMealPlanLayout(@RequestParam String calories){

        log.info("Generating meal plan for {} calories.", calories);
        return service.generateMealPlanTemplate(calories);

    }

    @PostMapping
    public DailyMealPlan getSampleMealPlan(@RequestParam String calories){
        log.info("Generating meal plan example for {} calories.", calories);
        return service.generateMealPlanExample(calories);
    }



}
