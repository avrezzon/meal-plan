package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.model.*;
import com.avrezzon.mealplan.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealPlannerService {

    private final FoodRepository repository;


    public DailyMealPlanTemplate generateMealPlanTemplate(String calories) {
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

    public DailyMealPlan generateMealPlanExample(String calories) {
        Map<MealType, List<ServingPortion>> examplePlan = new HashMap<>();
        var plan = generateMealPlanTemplate(calories);

        for (Map.Entry<MealType, List<Serving>> entry : plan.getDailyLayout().entrySet()) {
            log.debug("Entry Operating on: {}", entry);

            List<ServingPortion> actualFoodItems = new ArrayList<>();
            for (Serving serving : entry.getValue()) {
                log.debug("Original Guideline: {}", serving);
                ServingPortion updatedServing = new ServingPortion(serving.getServingQty(), serving.getType(),
                        List.of(getRandomFood(serving.getType())));
                log.info("Portion Generated: {}", updatedServing);
                actualFoodItems.add(updatedServing);
            }
            log.debug("Mapped plan: {} : {}", entry.getKey(), actualFoodItems);
            examplePlan.put(entry.getKey(), actualFoodItems);
        }
        return new DailyMealPlan(examplePlan);
    }

    protected Food getRandomFood(FoodType type) {
        switch (type) {
            case CARBOHYDRATE -> {
                return getRandomElement(repository.getAllCarbohydrates());
            }
            case FRUIT -> {
                return getRandomElement(repository.getAllFruits());
            }
            case PROTEIN -> {
                return getRandomElement(repository.getAllProteins());
            }
            case VEGETABLE -> {
                return getRandomElement(repository.getAllVegetables());
            }
            default -> throw new IllegalStateException();
        }
    }

    private Food getRandomElement(List<Food> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private static class DailyMealPlanLayoutFactory {
        public static DailyMealPlanTemplate getDailyMealPlan(CaloricIntake intakeLevel) {
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

        private static DailyMealPlanTemplate make1200CalorieMealPlan() {

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

            return new DailyMealPlanTemplate(mealPlan);
        }

        private static DailyMealPlanTemplate make1500CalorieMealPlan() {
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

            return new DailyMealPlanTemplate(mealPlan);
        }

        private static DailyMealPlanTemplate make1800CalorieMealPlan() {
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

            return new DailyMealPlanTemplate(mealPlan);
        }

        private static DailyMealPlanTemplate make2000CalorieMealPlan() {
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

            return new DailyMealPlanTemplate(mealPlan);
        }
    }
}
