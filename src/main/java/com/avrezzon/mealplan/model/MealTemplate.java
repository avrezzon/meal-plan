package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealTemplate implements Serializable {
    private MealType name;
    private List<Serving> servingGuideline;
}
