package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DailyMealPlanLayoutFactory {

    public static DailyMealPlan getDailyMealPlan(CaloricIntake intakeLevel) {
        switch (intakeLevel) {
            case CALORIES_1200 -> {
                return make1200CalorieMealPlan();
            }
            case CALORIES_1500 -> {
                return make1500CalorieMealPlan();
            }
            case CALORIES_1800 -> {
                return make1800CalorieMealPlan();
            }
            case CALORIES_2000 -> {
                return make2000CalorieMealPlan();
            }
            default -> {
                log.error("Not really sure how we got here but lets cause a problem");
                throw new IllegalStateException("Invalid Caloric intake level selected for meal plan generation");
            }
        }
    }

    private static DailyMealPlan make1200CalorieMealPlan() {

        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                new Serving(.5, FoodType.CARBOHYDRATE),
                new Serving(.5, FoodType.PROTEIN)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(1.0, FoodType.VEGETABLE),
                new Serving(1.0, FoodType.PROTEIN)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(1.0, FoodType.PROTEIN)));

        return new DailyMealPlan(mealPlan);
    }

    private static DailyMealPlan make1500CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(.75, FoodType.PROTEIN)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(1.0, FoodType.VEGETABLE),
                new Serving(1.0, FoodType.PROTEIN),
                new Serving(.5, FoodType.CARBOHYDRATE)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(2.0, FoodType.PROTEIN)));

        return new DailyMealPlan(mealPlan);
    }

    private static DailyMealPlan make1800CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(1.0, FoodType.PROTEIN)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(2.0, FoodType.VEGETABLE),
                new Serving(1.5, FoodType.PROTEIN),
                new Serving(1.0, FoodType.CARBOHYDRATE)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                new Serving(1.5, FoodType.CARBOHYDRATE),
                new Serving(2.0, FoodType.PROTEIN)));

        return new DailyMealPlan(mealPlan);
    }

    private static DailyMealPlan make2000CalorieMealPlan() {
        Map<MealType, List<Serving>> mealPlan = new HashMap<>();

        mealPlan.put(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(1.5, FoodType.PROTEIN)));
        mealPlan.put(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT),
                new Serving(1.0, FoodType.CARBOHYDRATE)));
        mealPlan.put(MealType.LUNCH, List.of(new Serving(2.0, FoodType.VEGETABLE),
                new Serving(2.0, FoodType.PROTEIN),
                new Serving(1.0, FoodType.CARBOHYDRATE)));
        mealPlan.put(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, FoodType.PROTEIN),
                new Serving(1.0, FoodType.FRUIT)));
        mealPlan.put(MealType.DINNER, List.of(new Serving(3.0, FoodType.VEGETABLE),
                new Serving(1.0, FoodType.CARBOHYDRATE),
                new Serving(2.0, FoodType.PROTEIN)));
        mealPlan.put(MealType.EVENING_SNACK, List.of(new Serving(1.0, FoodType.FRUIT)));

        return new DailyMealPlan(mealPlan);
    }

}
