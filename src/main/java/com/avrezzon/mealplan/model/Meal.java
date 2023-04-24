package com.avrezzon.mealplan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal implements Serializable {

    private LocalTime timeToEat;
    private MealType name;
    private List<ServingPortion> servingPortions;

}
