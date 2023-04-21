package com.avrezzon.mealplan.repository;

import com.avrezzon.mealplan.model.Food;
import com.avrezzon.mealplan.model.FoodType;
import com.avrezzon.mealplan.model.Measurement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Slf4j
@Repository
public class FoodRepositoryImpl implements FoodRepository{
    private final List<Food> FRUITS = List.of(
            new Food("Apple", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Banana", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Grapefruit", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Pear", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Berries", 1.0, Measurement.CUP, FoodType.FRUIT),
            new Food("Pineapple", 1.0, Measurement.CUP, FoodType.FRUIT),
            new Food("Orange", 1.0, Measurement.UNIT, FoodType.FRUIT),
            new Food("Kiwi", 1.0, Measurement.UNIT, FoodType.FRUIT)
    );

    private final List<Food> CARBOHYDRATES = List.of(
            new Food("Oatmeal", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Yams", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Brown rice", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Jasmine rice", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Baked potato", 1.0, Measurement.UNIT, FoodType.CARBOHYDRATE),
            new Food("Whole wheat pasta", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Whole wheat pasta", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE),
            new Food("Slice of whole wheat bread", 2.0, Measurement.UNIT, FoodType.CARBOHYDRATE),
            new Food("Lowfat yogurt", 1.0, Measurement.CUP, FoodType.CARBOHYDRATE)
    );

    private final List<Food> PROTEINS = List.of(
            new Food("Tuna", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Chicken", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Turkey", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Extra-lean beef", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Buffalo", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Fish", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Salmon", 3.0, Measurement.OZ, FoodType.PROTEIN),
            new Food("Protein bar", 1.0, Measurement.UNIT, FoodType.PROTEIN),
            new Food("Protein shake", 1.0, Measurement.UNIT, FoodType.PROTEIN),
            new Food("Cottage cheese", 0.75, Measurement.CUP, FoodType.PROTEIN),
            new Food("Egg whites", 6.0, Measurement.UNIT, FoodType.PROTEIN),
            new Food("Whole eggs", 3.0, Measurement.UNIT, FoodType.PROTEIN),
            new Food("Beans", 1.0, Measurement.CUP, FoodType.PROTEIN),
            new Food("Legumes", 1.0, Measurement.CUP, FoodType.PROTEIN),
            new Food("String chees", 2.0, Measurement.UNIT, FoodType.PROTEIN)
    );

    private final List<Food> VEGGIES = List.of(
            new Food("Artichoke", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Asparagus", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Bean sprouts", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Beets", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Broccoli", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Cabbage", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Carrots", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Cauliflower", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Celery", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Cucumber", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Edamame", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Eggplant", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Green beans", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Green leafy lettuce", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Kale", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Mushrooms", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Bell peppers", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Snow peas", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Spinach", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Tomatoes", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Yellow squash", 1.0, Measurement.CUP, FoodType.VEGETABLE),
            new Food("Zucchini", 1.0, Measurement.CUP, FoodType.VEGETABLE)
    );

    @Override
    public List<Food> getAllProteins() {
        return this.PROTEINS;
    }

    @Override
    public List<Food> getAllVegetables() {
        return this.VEGGIES;
    }

    @Override
    public List<Food> getAllFruits() {
        return this.FRUITS;
    }

    @Override
    public List<Food> getAllCarbohydrates() {
        return this.CARBOHYDRATES;
    }
}
