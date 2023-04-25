package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Preferences implements Serializable {
    private Integer caloricIntake;
    private List<MealTemplate> dailyMealOutline;
}
