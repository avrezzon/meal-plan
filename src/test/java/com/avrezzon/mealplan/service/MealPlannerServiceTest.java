package com.avrezzon.mealplan.service;

import com.avrezzon.mealplan.model.Food;
import com.avrezzon.mealplan.model.FoodType;
import com.avrezzon.mealplan.model.Meal;
import com.avrezzon.mealplan.model.Measurement;
import com.avrezzon.mealplan.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealPlannerServiceTest {

    @Mock
    private FoodRepository repository;

    @InjectMocks
    private MealPlannerService service;

    private final List<Food> FRUITS = List.of(
            new Food("Apple", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Banana", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Grapefruit", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Pear", 1.0, Measurement.UNIT, FoodType.FRUIT)
    );

    private final List<Food> CARBOHYDRATES = List.of(
            new Food("Oatmeal", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Yams", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Brown rice", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Jasmine rice", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE)
    );

    private final List<Food> PROTEINS = List.of(
            new Food("Tuna", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Chicken", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Turkey", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Beef", 3.0, Measurement.OZ, FoodType.PROTEIN)
    );

    private final List<Food> VEGGIES = List.of(
            new Food("Asparagus", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Celery", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Cucumber", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Green leafy lettuce", 1.0, Measurement.CUP, FoodType.VEGETABLE)
    );

    @BeforeEach
    void init() {
        when(repository.getAllCarbohydrates()).thenReturn(CARBOHYDRATES);
        when(repository.getAllFruits()).thenReturn(FRUITS);
        when(repository.getAllProteins()).thenReturn(PROTEINS);
        when(repository.getAllVegetables()).thenReturn(VEGGIES);
    }

    @Test
    void successfullyGenerateExampleMealPlan(){
        List<Meal> results = service.generateExampleMealPlan(2000);
        assertEquals(6, results.size());
    }


}