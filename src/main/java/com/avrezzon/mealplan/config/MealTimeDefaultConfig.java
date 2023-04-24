package com.avrezzon.mealplan.config;

import com.avrezzon.mealplan.model.MealType;

import java.time.LocalTime;

public class MealTimeDefaultConfig {

    public static LocalTime mapMealTime(MealType meal){
        switch (meal){
            case BREAKFAST -> { return LocalTime.of(8,0,0);}
            case MID_MORNING_SNACK -> { return LocalTime.of(10,0,0);}
            case LUNCH -> { return LocalTime.of(12, 0, 0);}
            case MID_AFTERNOON_SNACK -> { return LocalTime.of(14, 0, 0);}
            case DINNER -> { return LocalTime.of(18, 0, 0);}
            case EVENING_SNACK -> { return LocalTime.of(20, 0, 0);}
            default -> throw new IllegalStateException("Invalid MealType");
        }
    }
}
