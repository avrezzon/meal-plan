package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class DailyMealPlanTemplate implements Serializable {
    private Map<MealType, List<Serving>> dailyLayout;
}
