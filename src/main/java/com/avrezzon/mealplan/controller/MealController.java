package com.avrezzon.mealplan.controller;

import com.avrezzon.mealplan.dto.MealDto;
import com.avrezzon.mealplan.model.*;
import com.avrezzon.mealplan.repository.MealRepository;
import com.avrezzon.mealplan.service.MealPlannerService;
import com.avrezzon.mealplan.service.ValidationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("meal")
@RequiredArgsConstructor
public class MealController {
    private final MealPlannerService mealPlannerService;
    private final MealRepository mealRepository;
    private final ValidationService validationService;


    @GetMapping("template")
    public List<MealTemplate> getMealPlanTemplate(HttpSession session, @RequestParam Integer calories) {
        log.info("User active: {}", (String) session.getAttribute("user"));
        return mealPlannerService.generateMealPlan(calories);
    }

    @GetMapping("sample")
    public List<MealDto> getSampleMealPlan(@RequestParam Integer calories) {
        log.info("Generating meal plan example for {} calories.", calories);
        return mealPlannerService.generateExampleMealPlan(calories);
    }

    @PostMapping
    public Meal createMealPlan(HttpSession session, @RequestBody MealDto plannedMeal) {
        String activeUser= validationService.validateSessionUser(session);
        return mealPlannerService.createMeal(plannedMeal, activeUser);
    }

    @GetMapping
    public List<Meal> findByUsername(HttpSession session){
        String activeUser = validationService.validateSessionUser(session);
        return mealRepository.findAllByIdUsername(activeUser);
    }


}
