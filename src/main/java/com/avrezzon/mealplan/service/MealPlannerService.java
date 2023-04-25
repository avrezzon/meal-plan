package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.config.MealTimeDefaultConfig;
import com.avrezzon.mealplan.dto.MealDto;
import com.avrezzon.mealplan.model.*;

import com.avrezzon.mealplan.repository.FoodRepository;
import com.avrezzon.mealplan.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealPlannerService{

    private final FoodRepository foodRepository;
    private final MealRepository mealRepository;

    public List<MealTemplate> generateMealPlan(Integer calories) {
        log.info("Creating meal plan template for {} calories.", calories);
        return MealPlanFactory.createDailyTemplate(calories);
    }

    public List<MealDto> generateExampleMealPlan(Integer calories) {
        List<MealDto> sampleMeals = new ArrayList<>();
        List<ServingPortion> servingPortions;

        log.info("Creating sample meal plan for {} calories.", calories);

        var templates = MealPlanFactory.createDailyTemplate(calories);

        for (MealTemplate guide : templates) {
            log.debug("Creating meals for {}", guide.getName());
            servingPortions = new ArrayList<>();
            for (Serving serving : guide.getServingGuideline()) {
                servingPortions.add(fetchFood(serving));
            }
            sampleMeals.add(new MealDto(guide.getName(), servingPortions));
        }

        return sampleMeals;
    }

    //Ideally it would be better to cache the list of food items
    private ServingPortion fetchFood(Serving config) {
        List<Food> foodItems = new ArrayList<>();
        switch (config.getType()) {
            case FRUIT -> foodItems = foodRepository.getAllFruits();
            case PROTEIN -> foodItems = foodRepository.getAllProteins();
            case VEGETABLE -> foodItems = foodRepository.getAllVegetables();
            case CARBOHYDRATE -> foodItems = foodRepository.getAllCarbohydrates();
        }
        return new ServingPortion(config.getServingQty(), config.getType(),
                List.of(selectRandomElement(foodItems)));
    }

    private Food selectRandomElement(List<Food> food) {
        Random rand = new Random();
        return food.get(rand.nextInt(food.size()));
    }


    public Meal createMeal(MealDto dto, String username){
        Meal meal = Meal.builder()
                .id(Meal.MealReference.builder()
                        .mealType(dto.getName())
                        .date(LocalDate.now()) //FIXME
                        .username(username)
                        .build())
                .servingPortions(dto.getServingPortions())
                .build();
        return mealRepository.save(meal);
    }

    protected static class MealPlanFactory {
        protected static List<MealTemplate> createDailyTemplate(Integer calories) {
            switch (calories) {
                case 1200 -> {
                    return create1200Plan();
                }
                case 1500 -> {
                    return create1500Plan();
                }
                case 1800 -> {
                    return create1800Plan();
                }
                case 2000 -> {
                    return create2000Plan();
                }
                case 2500 -> {
                    return create2500Plan();
                }
                default -> {
                    log.error("Not really sure how we got here but lets cause a problem");
                    throw new IllegalStateException("Invalid Caloric intake level selected for meal plan generation");
                }
            }
        }

        private static List<MealTemplate> create2500Plan() {
            return List.of(
                    new MealTemplate(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.5, FoodType.CARBOHYDRATE),
                            new Serving(1.5, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_MORNING_SNACK, List.of(new Serving(1.5, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.LUNCH, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(2.0, FoodType.PROTEIN),
                            new Serving(1.5, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(2.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.DINNER, List.of(new Serving(3.0, FoodType.VEGETABLE),
                            new Serving(2.0, FoodType.CARBOHYDRATE),
                            new Serving(3.0, FoodType.PROTEIN))),
                    new MealTemplate(MealType.EVENING_SNACK, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.PROTEIN)))
            );
        }

        private static List<MealTemplate> create2000Plan() {
            return List.of(
                    new MealTemplate(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(1.5, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.LUNCH, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(2.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.DINNER, List.of(new Serving(3.0, FoodType.VEGETABLE),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(2.0, FoodType.PROTEIN))),
                    new MealTemplate(MealType.EVENING_SNACK, List.of(new Serving(1.0, FoodType.FRUIT)))
            );
        }

        private static List<MealTemplate> create1800Plan() {
            return List.of(
                    new MealTemplate(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(1.0, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.LUNCH, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(1.5, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.5, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(1.5, FoodType.CARBOHYDRATE),
                            new Serving(2.0, FoodType.PROTEIN)))
            );
        }

        private static List<MealTemplate> create1500Plan() {
            return List.of(
                    new MealTemplate(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(.75, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.LUNCH, List.of(new Serving(1.0, FoodType.VEGETABLE),
                            new Serving(1.0, FoodType.PROTEIN),
                            new Serving(.5, FoodType.CARBOHYDRATE))),
                    new MealTemplate(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(2.0, FoodType.PROTEIN)))
            );
        }

        private static List<MealTemplate> create1200Plan() {
            return List.of(
                    new MealTemplate(MealType.BREAKFAST, List.of(new Serving(1.0, FoodType.FRUIT),
                            new Serving(.5, FoodType.CARBOHYDRATE),
                            new Serving(.5, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_MORNING_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.LUNCH, List.of(new Serving(1.0, FoodType.VEGETABLE),
                            new Serving(1.0, FoodType.PROTEIN))),
                    new MealTemplate(MealType.MID_AFTERNOON_SNACK, List.of(new Serving(1.0, FoodType.PROTEIN),
                            new Serving(1.0, FoodType.FRUIT))),
                    new MealTemplate(MealType.DINNER, List.of(new Serving(2.0, FoodType.VEGETABLE),
                            new Serving(1.0, FoodType.CARBOHYDRATE),
                            new Serving(1.0, FoodType.PROTEIN)))
            );
        }
    }
}
